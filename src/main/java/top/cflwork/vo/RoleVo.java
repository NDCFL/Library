package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

import java.sql.Timestamp;
import java.util.List;
@Data
public class RoleVo {
	
	private String roleId;
	private String roleName;
	private String roleSign;
	private String remark;
	private String userIdCreate;
	private String gmtCreate;
	private String gmtModified;
	private List<String> menuIds;
	private String libraryId;
	@ApiModelProperty("分页对象")
	private Pager pager;

}
