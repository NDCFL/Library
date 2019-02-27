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
public class NewBookVo implements Serializable{

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
    @ApiModelProperty("isbn")
    private String isbn;

    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("索书号")
    private String callno;

    @XmlElement(name = "metaid")
    @XmlElementAnno
    @ApiModelProperty("Metaid 值")
    private String metaid;

    @XmlElement(name = "metatable")
    @XmlElementAnno
    @ApiModelProperty("metatable值")
    private String metatable;

    @XmlElement(name = "intdtion")
    @XmlElementAnno
    @ApiModelProperty("简介")
    private String intdtion;


    /**
     <title><![CDATA[老舍]]></title>
     <publisher><![CDATA[北京:中国和平出版社 ,1996.4]]></publisher>
     <publishDate><![CDATA[1996.4]]></publishDate>
     <author><![CDATA[孙之龙编著 郭奇英编著]]></author>
     <isbn><![CDATA[7-80101-131-7]]></isbn>
     <callno><![CDATA[I253]]></callno>
     <metaid><![CDATA[170037]]></metaid>
     <metatable><![CDATA[i_biblios]]></metatable>
     <intdtion><![CDATA[]]></intdtion>
     */

}
