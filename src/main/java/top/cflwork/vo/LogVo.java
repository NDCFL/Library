package top.cflwork.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

import java.util.Date;
@Data
public class LogVo {
	private String id;

	private String userId;

	private String username;

	private String operation;

	private Integer time;

	private String method;

	private String params;

	private String ip;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date gmtCreate;
	@ApiModelProperty("分页对象")
	private Pager pager;
	private String ids[];

}