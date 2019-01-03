package top.cflwork.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 通知通告发送记录
 *
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-10 11:08:06
 */
@Data
public class NotifyRecordVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  编号
     */
    private Long id;
    //通知通告ID
    private Long notifyId;
    //接受人
    private Long userId;
    //阅读标记
    private Integer isRead;
    //阅读时间
    private Date readDate;


}
