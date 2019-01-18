package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 图书分类
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-15 18:23:35
 */
@Data
public class BookTypeVo implements Serializable {
	private static final long serialVersionUID = 1L;
			@ApiModelProperty("图书分类编号")
		private String id;
			@ApiModelProperty("父id")
		private String parentId;
			@ApiModelProperty("分类名称")
		private String title;
			@ApiModelProperty("代号")
		private String code;
			@ApiModelProperty("状态")
		private Integer isActive;
			@ApiModelProperty("创建时间")
		private Date createTime;
		@ApiModelProperty("分页对象")
	private Pager pager;
}
