package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 纸质书的传递
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:34:56
 */
@Data
public class PaperExpressVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("纸质书传递编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("读者名字")
    private String readUserName;
    @ApiModelProperty("读者卡号")
    private String readUserCardNum;
    @ApiModelProperty("图书编号")
    private String bookId;
    @ApiModelProperty("isbn号")
    private String isbn;
    @ApiModelProperty("图书名称")
    private String bookName;
    @ApiModelProperty("状态 1：可抢单 2：已抢单 3：已送达 4：已评分 5：未送达 6：申请已取消")
    private Integer status;
    @ApiModelProperty("评分")
    private Integer score;
    @ApiModelProperty("理由备注")
    private String reason;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
