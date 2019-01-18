package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 借阅记录管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:55:59
 */
@Data
public class BorrowVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("借阅编号")
    private String id;
    @ApiModelProperty("借阅读者编号")
    private String readUserIdIn;
    @ApiModelProperty("图书编号")
    private String bookId;
    @ApiModelProperty("借出时间")
    private Date borrowTime;
    @ApiModelProperty("归还时间")
    private Date inTime;
    @ApiModelProperty("图书名")
    private String bookName;
    @ApiModelProperty("出版时间")
    private Date publishTime;
    @ApiModelProperty("isbn")
    private String isbn;
    @ApiModelProperty("借入者")
    private String inName;
    @ApiModelProperty("借出者")
    private String outName;
    @ApiModelProperty("状态 1：已借出 2：已归还 3：借阅异常")
    private Integer status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
