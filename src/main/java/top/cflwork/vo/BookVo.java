package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图书表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-05 12:32:55
 */
@Data
public class BookVo implements Serializable {
	private static final long serialVersionUID = 1L;
			@ApiModelProperty("图书编号")
		private Long id;
			@ApiModelProperty("图书名称")
		private String bookName;
			@ApiModelProperty("图书序列号")
		private Long bookImei;
			@ApiModelProperty("作者")
		private String author;
			@ApiModelProperty("发布时间")
		private Date publicTime;
			@ApiModelProperty("创建时间")
		private Date createTime;
	}
