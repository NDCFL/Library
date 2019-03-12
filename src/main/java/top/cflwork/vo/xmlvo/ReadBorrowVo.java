package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ReadBorrowVo {

    @XmlElement(name = "status")
    @XmlElementAnno
    @ApiModelProperty("状态")
    private String status;

    @XmlElement(name = "barcode")
    @XmlElementAnno
    @ApiModelProperty("条码号")
    private String barcode;

    @XmlElement(name = "title")
    @XmlElementAnno
    @ApiModelProperty("书名")
    private String title;

    @XmlElement(name = "callno")
    @XmlElementAnno
    @ApiModelProperty("条码号")
    private String callno;

    @XmlElement(name = "cirtype")
    @XmlElementAnno
    @ApiModelProperty("流通类别")
    private String cirtype;

    @XmlElement(name = "author")
    @XmlElementAnno
    @ApiModelProperty("作者")
    private String author;

    @XmlElement(name = "metaid")
    @XmlElementAnno
    @ApiModelProperty("metaid")
    private String metaid;

    @XmlElement(name = "metatable")
    @XmlElementAnno
    @ApiModelProperty("metatable")
    private String metatable;

    @XmlElement(name = "eventType")
    @XmlElementAnno
    @ApiModelProperty("借出还回类型")
    private String eventType;

    @XmlElement(name = "updateDate")
    @XmlElementAnno
    @ApiModelProperty("日期")
    private String updateDate;

    /**
     <barcode><![CDATA[01091800000034]]></barcode>
     <title><![CDATA[八十年代中学生]]></title>
     <callno><![CDATA[G635.5-64/1]]></callno>
     <cirtype><![CDATA[一卡通中文书]]></cirtype>
     <author><![CDATA[任曙林图/文 鲍昆文 顾铮文]]></author>
     <metaid><![CDATA[1019]]></metaid>
     <metatable><![CDATA[i_bbl_biblios]]></metatable>
     <eventType><![CDATA[读者还回]]></eventType>
     <updateDate><![CDATA[2016-01-02]]></updateDate>

     title				书名
     updaetDate				日期
     callno				索书号
     cirtype				流通类别
     metatable				馆藏metatable
     metaid				馆藏metaid
     eventType				借出还回类型
     author				作者
     */


}
