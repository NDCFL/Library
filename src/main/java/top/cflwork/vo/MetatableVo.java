package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.util.Date;

/**
 * 图书书目信息表
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-15 10:15:48
 */
@Data
public class MetatableVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("")
    private String id;
    @ApiModelProperty("书名")
    private String title;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("isbn号")
    private String isbn;
    @ApiModelProperty("出版社")
    private String publisher;
    @ApiModelProperty("出版时间")
    private String publishDate;
    @ApiModelProperty("索书号")
    private String callno;
    @ApiModelProperty("分类号")
    private String classno;
    @ApiModelProperty("简介")
    private String abbstract;
    @ApiModelProperty("价格")
    private String price;
    @ApiModelProperty("出版名称")
    private String publishName;
    @ApiModelProperty("出版地址")
    private String publishAddress;
    @ApiModelProperty("ctrlno")
    private String ctrlno;
    @ApiModelProperty("主题")
    private String subject;
    @ApiModelProperty("出版项")
    private String publish;
    @ApiModelProperty("备注")
    private String note;
    @ApiModelProperty("版本")
    private String version;
    @ApiModelProperty("馆藏数量")
    private Integer assetCount;
    @ApiModelProperty("metaid")
    private String metaid;
    @ApiModelProperty("metatable")
    private String metatable;
    @ApiModelProperty("封面图")
    private String faceImg;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
