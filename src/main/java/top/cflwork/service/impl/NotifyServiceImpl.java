package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cflwork.dao.NotifyDao;
import top.cflwork.dao.NotifyRecordDao;
import top.cflwork.dao.UserDao;
import top.cflwork.vo.NotifyVo;
import top.cflwork.vo.NotifyDTO;
import top.cflwork.vo.NotifyRecordVo;
import top.cflwork.vo.UserVo;
import top.cflwork.service.DictService;
import top.cflwork.service.NotifyService;
import top.cflwork.service.SessionService;
import top.cflwork.util.DateUtils;
import top.cflwork.util.PageUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotifyDao notifyDao;
    @Autowired
    private NotifyRecordDao recordDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DictService dictService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public NotifyVo get(String id) {
        NotifyVo rVo = notifyDao.get(id);
        rVo.setType(dictService.getName("oa_notify_type", rVo.getType()));
        return rVo;
    }

    @Override
    public List<NotifyVo> list(NotifyVo notifyVo) {
        List<NotifyVo> notifys = notifyDao.list(notifyVo);
        for (NotifyVo notifyVo1 : notifys) {
            notifyVo1.setType(dictService.getName("oa_notify_type", notifyVo1.getType()));
        }
        return notifys;
    }

    @Override
    public long count(NotifyVo notifyVo) {
        return notifyDao.count(notifyVo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(NotifyVo notify) {
        notify.setUpdateDate(new Date());
        int r = notifyDao.save(notify);
        // 保存到接受者列表中
        String[] userIds = notify.getUserIds();
        String notifyId = notify.getId();
        List<NotifyRecordVo> records = new ArrayList<>();
        for (String userId : userIds) {
            NotifyRecordVo record = new NotifyRecordVo();
            record.setNotifyId(notifyId);
            record.setUserId(userId);
            record.setIsRead(0);
            records.add(record);
        }
        recordDao.batchSave(records);
        //给在线用户发送通知
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (UserVo userVo : sessionService.listOnlineUser()) {
                    for (String userId : userIds) {
                        if (userId.equals(userVo.getUserId())) {
                            template.convertAndSendToUser(userVo.toString(), "/queue/notifications", "新消息：" + notify.getTitle());
                        }
                    }
                }
            }
        });
        executor.shutdown();
        return r;
    }

    @Override
    public int update(NotifyVo notify) {
        return notifyDao.update(notify);
    }

    @Transactional
    @Override
    public int remove(String id) {
        recordDao.removeByNotifbyId(id);
        return notifyDao.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(String[] ids) {
        recordDao.batchRemoveByNotifbyId(ids);
        return notifyDao.batchRemove(ids);
    }


    @Override
    public PageUtils selfList(Map<String, Object> map) {
        List<NotifyDTO> rows = notifyDao.listDTO(map);
        for (NotifyDTO notifyDTO : rows) {
            notifyDTO.setBefore(DateUtils.getTimeBefore(notifyDTO.getUpdateDate()));
            notifyDTO.setSender(userDao.get(notifyDTO.getCreateBy()).getName());
        }
        PageUtils page = new PageUtils(rows, notifyDao.countDTO(map));
        return page;
    }

}
