package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;
import java.util.Date;
/**
 * 积分配置表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-23 16:17:48
 */
@Data
public class IntegralTypeVo implements Serializable {
	private static final long serialVersionUID = 1L;
			@ApiModelProperty("积分配置编号")
		private String id;
			@ApiModelProperty("积分名称")
		private String name;
			@ApiModelProperty("积分码")
		private String code;
			@ApiModelProperty("图书馆编号")
		private String libraryId;
			@ApiModelProperty("创建时间")
		private String createTime;
		@ApiModelProperty("分页对象")
	private Pager pager;
}
