package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 座位管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:09:36
 */
@Data
public class SeatVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("座位编号")
    private String id;
    @ApiModelProperty("座位名称")
    private String title;
    @ApiModelProperty("阅览室编号")
    private String readdingId;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    @ApiModelProperty("阅览室名称")
    private String readdingName;
}
