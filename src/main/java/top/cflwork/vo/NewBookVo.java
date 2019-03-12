package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.util.Date;

/**
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-12 11:02:18
 */
@Data
public class NewBookVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("新书通报编号")
    private String id;
    @ApiModelProperty("图书标题")
    private String title;
    @ApiModelProperty("出版社")
    private String publisher;
    @ApiModelProperty("出版时间")
    private String publishDate;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("isbn")
    private String isbn;
    @ApiModelProperty("callno")
    private String callno;
    @ApiModelProperty("metaid")
    private String metaid;
    @ApiModelProperty("metatable")
    private String metatable;
    @ApiModelProperty("简介")
    private String intdtion;
    @ApiModelProperty("图书封面")
    private String faceImg;
    @ApiModelProperty(value = "分页对象",required = true)
    private Pager pager;
}
