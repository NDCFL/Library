package top.cflwork.service.impl;

import top.cflwork.service.DictService;
import top.cflwork.util.StringUtils;
import top.cflwork.dao.DictDao;
import top.cflwork.vo.UserVo;
import top.cflwork.vo.DictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    @Override
    public DictVo get(Long id) {
        return dictDao.get(id);
    }

    @Override
    public List<DictVo> list(Map<String, Object> map) {
        return dictDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dictDao.count(map);
    }

    @Override
    public int save(DictVo dict) {
        return dictDao.save(dict);
    }

    @Override
    public int update(DictVo dict) {
        return dictDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        return dictDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return dictDao.batchRemove(ids);
    }

    @Override

    public List<DictVo> listType() {
        return dictDao.listType();
    }

    @Override
    public String getName(String type, String value) {
        Map<String, Object> param = new HashMap<String, Object>(16);
        param.put("type", type);
        param.put("value", value);
        String rString = dictDao.list(param).get(0).getName();
        return rString;
    }

    @Override
    public List<DictVo> getHobbyList(UserVo userVo) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "hobby");
        List<DictVo> hobbyList = dictDao.list(param);

        if (StringUtils.isNotEmpty(userVo.getHobby())) {
            String userHobbys[] = userVo.getHobby().split(";");
            for (String userHobby : userHobbys) {
                for (DictVo hobby : hobbyList) {
                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
                        continue;
                    }
                    hobby.setRemarks("true");
                    break;
                }
            }
        }

        return hobbyList;
    }

    @Override
    public List<DictVo> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return dictDao.list(param);
    }

    @Override
    public List<DictVo> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return dictDao.list(param);
    }

}
