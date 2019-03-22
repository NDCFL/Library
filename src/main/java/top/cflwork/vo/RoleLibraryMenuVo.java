package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

@Data
public class RoleLibraryMenuVo {
	private String id;
	private String  libraryId;
	private String menuId;
	@ApiModelProperty("分页对象")
	private Pager pager;

}
