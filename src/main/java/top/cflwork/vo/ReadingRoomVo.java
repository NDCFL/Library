package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 阅览室管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:16:56
 */
@Data
public class ReadingRoomVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("阅览室编号")
    private String id;
    @ApiModelProperty("阅览室名称")
    private String title;
    @ApiModelProperty("位置")
    private String location;
    @ApiModelProperty("可容纳人数")
    private Integer peopleNum;
    @ApiModelProperty("描述")
    private String content;
    @ApiModelProperty("状态，1：启用 2：禁用")
    private Integer isActive;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
