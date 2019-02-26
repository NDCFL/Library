package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import top.cflwork.common.GroupTwo;
import top.cflwork.common.Pager;
import top.cflwork.config.Constant;

import javax.validation.constraints.NotBlank;

/**
 * 读者管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 11:01:53
 */
@Data
public class ReadUserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("app端的读者用户")
    private String id;
    @ApiModelProperty("读者姓名")
    private String name;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("用户头像")
    private String faceImg;
    @ApiModelProperty("读者手机号,登录账号")
    @NotBlank(groups = GroupTwo.class,message = "电话号码不能你为空")
    @Length(max = 11,groups = GroupTwo.class,message = "电话号码长度应为{max}")
    private String phone;
    @ApiModelProperty("读者登录密码")
    private String password;
    @ApiModelProperty("读者证号")
    private String cardNum;
    @ApiModelProperty("读者证号密码")
    private String cardPwd;
    @ApiModelProperty("读者证号发证日期")
    private Date cardRcDate;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("qq号")
    private String qq;
    @ApiModelProperty("微信号")
    private String wx;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("工作地址")
    private String workAdress;
    @ApiModelProperty("状态，0：启用，1:禁用")
    private Integer isActive;
    @ApiModelProperty("个性签名")
    private String remark;
    @ApiModelProperty("地址")
    private String adress;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;

}
