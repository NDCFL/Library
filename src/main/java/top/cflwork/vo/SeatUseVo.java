package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 座位预约管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:23:53
 */
@Data
public class SeatUseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("预约管理")
    private String id;
    @ApiModelProperty("阅览室编号")
    private String readingRoomId;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("座位编号")
    private String seatId;
    @ApiModelProperty("读者名称")
    private String name;
    @ApiModelProperty("预约起始时间")
    private Date useStartTime;
    @ApiModelProperty("预约终止时间")
    private Date useEndTime;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("阅览室名称")
    private String readingRoomName;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
