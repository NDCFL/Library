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
public class BorrowVo implements Serializable {

    @XmlElement(name = "status")
    @XmlElementAnno
    @ApiModelProperty("status")
    private String status;

    @XmlElement(name = "barcode")
    @XmlElementAnno
    @ApiModelProperty("条码号")
    private String barcode;

    @XmlElement(name = "title")
    @XmlElementAnno
    @ApiModelProperty("标题")
    private String title;

    @XmlElement(name = "loandate")
    @XmlElementAnno
    @ApiModelProperty("借书日期")
    private String loandate;

    @XmlElement(name = "retudate")
    @XmlElementAnno
    @ApiModelProperty("还回日期")
    private String retudate;

    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("索书号")
    private String callno;

    @XmlElement(name = "cirtype")
    @XmlElementAnno
    @ApiModelProperty("流通类别")
    private String cirtype;

    @XmlElement(name = "renenum")
    @XmlElementAnno
    @ApiModelProperty("续借次数")
    private String renenum;

    @XmlElement(name = "metaid")
    @XmlElementAnno
    @ApiModelProperty("书目metaid")
    private String metaid;

    @XmlElement(name = "metatable")
    @XmlElementAnno
    @ApiModelProperty("书目metatable")
    private String metatable;

    @XmlElement(name = "local")
    @XmlElementAnno
    @ApiModelProperty("位置")
    private String local;

    @XmlElement(name = "sublib")
    @XmlElementAnno
    @ApiModelProperty("分馆")
    private String sublib;

    /**
     <status><![CDATA[普通借出]]></status>
     <barcode><![CDATA[223456789]]></barcode>
     <title><![CDATA[权利的游戏]]></title>
     <loandate><![CDATA[2018-11-08]]></loandate>
     <retudate><![CDATA[2019-01-07]]></retudate>
     <callno><![CDATA[I]]></callno>
     <cirtype><![CDATA[中文类图书]]></cirtype>
     <renenum><![CDATA[1]]></renenum>
     <metaid><![CDATA[286697]]></metaid>
     <metatable><![CDATA[i_biblios]]></metatable>
     <local><![CDATA[QHL_BK01]]></local>
     <sublib><![CDATA[QHL]]></sublib>
     */

}
