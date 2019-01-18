package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 存储读者的地址
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 14:55:55
 */
@Data
public class AddressVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("地址编号")
    private String id;
    @ApiModelProperty("用户编号")
    private String readUserId;
    @ApiModelProperty("联系人")
    private String name;
    @ApiModelProperty("联系方式")
    private String phone;
    @ApiModelProperty("地址")
    private String adress;
    @ApiModelProperty("是否默认地址")
    private Integer isOften;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
