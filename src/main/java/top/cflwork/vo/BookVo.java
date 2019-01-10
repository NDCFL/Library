package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

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
    private String id;
    @ApiModelProperty("图书名称")
    private String bookName;
    @ApiModelProperty("图书序列号")
    private String bookImei;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("发布时间")
    private Date publicTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    @ApiModelProperty("批量操作时保存编号，利用数组存储")
    private String[] ids;

}
