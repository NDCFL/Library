package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.util.Date;

/**
 * 图书书目信息
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 17:23:37
 */
@Data
public class CollectionBookVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("编号")
    private String id;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("出版社")
    private String publisher;
    @ApiModelProperty("出版时间")
    private String publishDate;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("isbn号")
    private String isbn;
    @ApiModelProperty("索书号")
    private String callno;
    @ApiModelProperty("分类号")
    private String classno;
    @ApiModelProperty("馆藏数目")
    private Integer assetCount;
    @ApiModelProperty("书目metaid")
    private String metaid;
    @ApiModelProperty("书目metatable")
    private String metatable;
    @ApiModelProperty("原分馆")
    private String sublib;
    @ApiModelProperty("原馆藏地点")
    private String local;
    @ApiModelProperty("当前分馆")
    private String cursublib;
    @ApiModelProperty("当前馆藏地点")
    private String curlocal;
    @ApiModelProperty("价格（单位：分）")
    private Double price;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
