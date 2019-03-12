package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class MetaTablesVo implements Serializable{


    @XmlElement(name = "title")
    @XmlElementAnno
    @ApiModelProperty("图书标题")
    private String title;

    @XmlElement(name = "author")
    @XmlElementAnno
    @ApiModelProperty("作者")
    private String author;

    @XmlElement(name = "isbn")
    @XmlElementAnno
    @ApiModelProperty("isbn号")
    private String isbn;

    @XmlElement(name = "publisher")
    @XmlElementAnno
    @ApiModelProperty("出版社")
    private String publisher;

    @XmlElement(name = "publishDate")
    @XmlElementAnno
    @ApiModelProperty("出版时间")
    private String publishDate;


    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("书架号")
    private String callno;

    @XmlElement(name = "classno")
    @XmlElementAnno
    @ApiModelProperty("分类号")
    private String classno;

    @XmlElement(name = "abbstract")
    @XmlElementAnno
    @ApiModelProperty("简介")
    private String abbstract;


    @XmlElement(name = "price")
    @XmlElementAnno
    @ApiModelProperty("价格")
    private String price;

    @XmlElement(name = "page")
    @XmlElementAnno
    @ApiModelProperty("页码")
    private String page;

    @XmlElement(name = "publishName")
    @XmlElementAnno
    @ApiModelProperty("出版名称")
    private String publishName;


    @XmlElement(name = "publishAddress")
    @XmlElementAnno
    @ApiModelProperty("出版地址")
    private String publishAddress;

    @XmlElement(name = "ctrlno")
    @XmlElementAnno
    @ApiModelProperty("控制号")
    private String ctrlno;

    @XmlElement(name = "subject")
    @XmlElementAnno
    @ApiModelProperty("主题")
    private String subject;

    @XmlElement(name = "publish")
    @XmlElementAnno
    @ApiModelProperty("出版项")
    private String publish;

    @XmlElement(name = "note")
    @XmlElementAnno
    @ApiModelProperty("备注")
    private String note;

    @XmlElement(name = "diagonal")
    @XmlElementAnno
    @ApiModelProperty("（无用）")
    private String diagonal;

    @XmlElement(name = "topic")
    @XmlElementAnno
    @ApiModelProperty("（无用）")
    private String topic;

    @XmlElement(name = "version")
    @XmlElementAnno
    @ApiModelProperty("版本")
    private String version;

    @ApiModelProperty("馆藏数量")
    private Integer assetCount;
    @ApiModelProperty("metaid")
    private String metaid;
    @ApiModelProperty("metatable")
    private String metatable;
    @ApiModelProperty("封面图")
    private String faceImg = "/book.gif";

    /*
    abbstract 摘要
ctrlno 控制号
subject 主题
publish 出版项
price 价格
page 页码
note 备注
diagonal （无用）
topic （无用）
version 版本
publishName 出版社名称
publishAddress 出版社地址

    */



}
