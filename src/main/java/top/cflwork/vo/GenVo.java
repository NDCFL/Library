package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 情报管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 18:10:40
 */
@Data
public class GenVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("情报传递编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("情报标题")
    private String title;
    @ApiModelProperty("项目简介")
    private String content;
    @ApiModelProperty("需求")
    private String genHave;
    @ApiModelProperty("情报形式")
    private String shape;
    @ApiModelProperty("状态 1：接收申请 2：拒绝申请，3：未处理")
    private Integer status;
    @ApiModelProperty("理由")
    private String reason;
    @ApiModelProperty("完成时间")
    private Date endTime;
    @ApiModelProperty("申请时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    @ApiModelProperty("读者用户名")
    private String readUserName;
    @ApiModelProperty("读者联系方式")
    private String phone;
    @ApiModelProperty("电子邮件")
    private String email;
    @ApiModelProperty("工作单位")
    private String workAddress;
    @ApiModelProperty("工作地址")
    private String address;
    @ApiModelProperty("结束时间")
    private String endsTime;
    @ApiModelProperty("图书馆编号")
    private String libraryId;
}
