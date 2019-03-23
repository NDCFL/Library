package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 预约场地管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 15:56:04
 */
@Data
public class SpaceUseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("场地预约编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("场地编号")
    private String spaceId;
    @ApiModelProperty("主题")
    private String title;
    @ApiModelProperty("参加人数")
    private Integer peopleNum;
    @ApiModelProperty("预约时间")
    private Date useTime;
    @ApiModelProperty("预约说明")
    private String remark;
    @ApiModelProperty("联系人")
    private String name;
    @ApiModelProperty("联系方式")
    private String phone;
    @ApiModelProperty("状态 1：审核通过 2：审核不通过，3：请求处理")
    private Integer status;
    @ApiModelProperty("审核理由")
    private String reason;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    @ApiModelProperty("图书馆编号")
    private String libraryId;

}
