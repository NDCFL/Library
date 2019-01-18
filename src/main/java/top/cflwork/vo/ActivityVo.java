package top.cflwork.vo;

import com.xiaoleilu.hutool.date.DateUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 活动管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-10 17:13:51
 */
@Data
public class ActivityVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("活动编号")
    private String id;
    @ApiModelProperty("活动标题")
    private String title;
    @ApiModelProperty("位置")
    private String location;
    @ApiModelProperty("容纳人数")
    private Integer peopleNum;
    @ApiModelProperty("描述")
    private String content;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    private String time;
}
