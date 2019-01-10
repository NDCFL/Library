package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 字典表
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-29 18:28:07
 */
@Data
public class DictVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private String id;
	//标签名
	private String name;
	//数据值
	private String value;
	//类型
	private String type;
	//描述
	private String description;
	//排序（升序）
	private BigDecimal sort;
	//父级编号
	private String parentId;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private String updateBy;
	//更新时间
	private Date updateDate;
	//备注信息
	private String remarks;
	//删除标记
	private String delFlag;
	private String ids[];
	@ApiModelProperty("分页对象")
	private Pager pager;

}
