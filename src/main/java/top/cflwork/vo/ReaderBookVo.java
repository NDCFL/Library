package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 城市书房
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:43:53
 */
@Data
public class ReaderBookVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("城市书房编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("图书编号")
    private String bookId;
    @ApiModelProperty("图书类型名称")
    private String bookTypeName;
    @ApiModelProperty("作者")
    private String bookAuther;
    @ApiModelProperty("出版社")
    private String cbs;
    @ApiModelProperty("isbn号")
    private String isbn;
    @ApiModelProperty("图书名称")
    private String bookName;
    @ApiModelProperty("读者名称")
    private String readUserName;
    @ApiModelProperty("状态， 1：已删除，2：未删除")
    private String isActive;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
    @ApiModelProperty("图书馆编号")
    private String libraryId;

}
