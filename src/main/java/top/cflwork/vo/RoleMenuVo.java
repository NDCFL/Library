package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

@Data
public class RoleMenuVo {
	private String id;
	private String  roleId;
	private String menuId;
	@ApiModelProperty("分页对象")
	private Pager pager;

}
