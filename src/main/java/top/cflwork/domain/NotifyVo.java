package top.cflwork.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


/**
 * 通知通告
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-05 17:11:16
 */
@Data
public class NotifyVo implements Serializable {
	private static final long serialVersionUID = 1L;
	//编号
	private Long id;
	//类型
	private String type;
	//标题
	private String title;
	//内容
	private String content;
	//附件
	private String files;
	//状态
	private String status;
	//创建者
	private Long createBy;
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
	
	private Long[] userIds;


}
