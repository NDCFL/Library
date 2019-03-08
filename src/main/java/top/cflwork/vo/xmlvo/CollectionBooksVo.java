package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CollectionBooksVo implements Serializable {


    @XmlElement(name = "barcode")
    @XmlElementAnno
    @ApiModelProperty("条码号")
    private String barcode;

    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("索书号")
    private String callno;

    @XmlElement(name = "regdate")
    @XmlElementAnno
    @ApiModelProperty("入馆时间")
    private String regdate;

    @XmlElement(name = "retudate")
    @XmlElementAnno
    @ApiModelProperty("还回日期")
    private String retudate;

    @XmlElement(name = "status")
    @XmlElementAnno
    @ApiModelProperty("状态")
    private String status;

    @XmlElement(name = "metaid")
    @XmlElementAnno
    @ApiModelProperty("Metaid 值")
    private String metaid;

    @XmlElement(name = "metatable")
    @XmlElementAnno
    @ApiModelProperty("metatable值")
    private String metatable;

    @XmlElement(name = "price")
    @XmlElementAnno
    @ApiModelProperty("price价格")
    private String price;


    @XmlElement(name = "sublib")
    @XmlElementAnno
    @ApiModelProperty("原分馆")
    private String sublib;

    @XmlElement(name = "local")
    @XmlElementAnno
    @ApiModelProperty("原馆藏地点")
    private String local;

    @XmlElement(name = "cursublib")
    @XmlElementAnno
    @ApiModelProperty("当前分馆")
    private String cursublib;

    @XmlElement(name = "curlocal")
    @XmlElementAnno
    @ApiModelProperty("当前馆藏地点")
    private String curlocal;
    /**
     <barcode><![CDATA[010501610]]></barcode>
     <callno><![CDATA[J218.2/77]]></callno>
     <regdate><![CDATA[2013-10-30]]></regdate>
     <retudate><![CDATA[2015-02-20]]></retudate>
     <status><![CDATA[普通借出]]></status>
     <metaid><![CDATA[269511]]></metaid>
     <metatable><![CDATA[i_biblios]]></metatable>
     <price><![CDATA[3800]]></price>
     <sublib><![CDATA[青海省图书馆]]></sublib>
     <local><![CDATA[一楼]]></local>
     <cursublib><![CDATA[青海省图书馆]]></cursublib>
     <curlocal><![CDATA[一楼]]></curlocal>
     */
}
