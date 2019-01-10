package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;

import java.io.Serializable;


/**
 * 部门管理
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-27 14:28:36
 */
@Data
public class DeptVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String deptId;
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	private String parentId;
	//部门名称
	private String name;
	//排序
	private Integer orderNum;
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	private Integer delFlag;
	private String ids[];
	@ApiModelProperty("分页对象")
	private Pager pager;

}
