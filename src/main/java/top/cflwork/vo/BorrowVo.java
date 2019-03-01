package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.util.Date;

/**
 * 借阅记录管理
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-01 17:27:02
 */
@Data
public class BorrowVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("借阅编号")
    private String id;
    @ApiModelProperty("读者卡号")
    private String cardno;
    @ApiModelProperty("借书时间")
    private Date loandate;
    @ApiModelProperty("还书时间")
    private Date retudate;
    @ApiModelProperty("图书名")
    private String title;
    @ApiModelProperty("索书号")
    private String callno;
    @ApiModelProperty("isbn")
    private String isbn;
    @ApiModelProperty("流通类别")
    private String cirtype;
    @ApiModelProperty("续借次数")
    private Integer renenum;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("读者编号")
    private String readUserIdIn;
    @ApiModelProperty("图书编号")
    private String bookId;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
