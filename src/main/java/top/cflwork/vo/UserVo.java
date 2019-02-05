package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import top.cflwork.common.Pager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private String userId;
    // 用户名
    private String username;
    // 用户真实姓名
    private String name;
    // 密码
    private String password;
    // 部门
    private String deptId;
    private String deptName;
    // 邮箱
    private String email;
    // 手机号
    private String mobile;
    // 状态 0:禁用，1:正常
    private Integer status;
    // 创建用户id
    private String userIdCreate;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    //角色
    private List<String> roleIds;
    //性别
    private String sex;
    //出身日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    //图片url
    private String headIcon;
    //现居住地
    private String liveAddress;
    //爱好
    private String hobby;
    //省份
    private String province;
    //所在城市
    private String city;
    //所在地区
    private String district;
    @ApiModelProperty("分页对象")
    private Pager pager;

}