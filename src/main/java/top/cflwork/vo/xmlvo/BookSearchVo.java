package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.Pager;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BookSearchVo implements Serializable {

    @ApiModelProperty("图书编号")
    private String id;

    @XmlElement(name = "title")
    @XmlElementAnno
    @ApiModelProperty("图书标题")
    private String title;

    @XmlElement(name = "publisher")
    @XmlElementAnno
    @ApiModelProperty("出版社")
    private String publisher;

    @XmlElement(name = "publishDate")
    @XmlElementAnno
    @ApiModelProperty("出版时间")
    private String publishDate;


    @XmlElement(name = "author")
    @XmlElementAnno
    @ApiModelProperty("作者")
    private String author;

    @XmlElement(name = "isbn")
    @XmlElementAnno
    @ApiModelProperty("isbn号")
    private String isbn;

    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("书架号")
    private String callno;

    @XmlElement(name = "classno")
    @XmlElementAnno
    @ApiModelProperty("分类号")
    private String classno;


    @XmlElement(name = "assetCount")
    @XmlElementAnno
    @ApiModelProperty("该条书目下的馆藏数量")
    private String assetCount;


    @XmlElement(name = "metaid")
    @XmlElementAnno
    @ApiModelProperty("书目metaid")
    private String metaid;

    @XmlElement(name = "metatable")
    @XmlElementAnno
    @ApiModelProperty("书目metatable")
    private String metatable;

    @XmlElement(name = "price")
    @XmlElementAnno
    @ApiModelProperty("价格")
    private String price;
    @ApiModelProperty("封面需要加上前缀")
    private String faceImg = "/book.gif";
    @ApiModelProperty("图书馆编号")
    private String libraryId;
}
