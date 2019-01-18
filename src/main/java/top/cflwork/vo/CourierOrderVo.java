package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 快递订单管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:13:02
 */
@Data
public class CourierOrderVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("快递订单编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("读者名字")
    private String readUserName;
    @ApiModelProperty("读者卡号")
    private String readUserCardNum;
    @ApiModelProperty("抢单员手机号")
    private String courierPhone;
    @ApiModelProperty("抢单员身份证号")
    private String courierIdcard;
    @ApiModelProperty("抢单员地址")
    private String courierAdress;
    @ApiModelProperty("申请时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
