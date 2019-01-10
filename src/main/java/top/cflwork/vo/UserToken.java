package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.io.Serializable;

/**
 * @author cflworks 275300091@qq.com
 * @version V1.0
 */
public class UserToken implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String username;
    private String name;
    private String password;
    private String deptId;
    @ApiModelProperty("分页对象")
    private Pager pager;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
