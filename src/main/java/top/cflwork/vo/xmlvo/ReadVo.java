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
public class ReadVo implements Serializable{
    @XmlElement(name="name")
    @XmlElementAnno
    @ApiModelProperty("姓名")
    private String name;

    @XmlElement(name="certype")
    @XmlElementAnno
    @ApiModelProperty("证件类别")
    private String certype;

    @XmlElement(name="gender")
    @XmlElementAnno
    @ApiModelProperty("性别")
    private String gender;

    @XmlElement(name="cardtype")
    @XmlElementAnno
    @ApiModelProperty("证类型")
    private String cardtype;

    @XmlElement(name="address")
    @XmlElementAnno
    @ApiModelProperty("地址")
    private String address;

    @XmlElement(name="mobile")
    @XmlElementAnno
    @ApiModelProperty("号码")
    private String mobile;

    @XmlElement(name="idno")
    @XmlElementAnno
    @ApiModelProperty("证件证号")
    private String idno;

    @XmlElement(name="arrear")
    @XmlElementAnno
    @ApiModelProperty("欠款金额（单位分）")
    private String arrear;

    @XmlElement(name="bill")
    @XmlElementAnno
    @ApiModelProperty("欠款金额（单位分）")
    private String bill;

    @XmlElement(name="deposit")
    @XmlElementAnno
    @ApiModelProperty("账户余额（单位分）")
    private String deposit;

    @XmlElement(name="status")
    @XmlElementAnno
    @ApiModelProperty("证状态")
    private String status;

    @XmlElement(name="reserveCount")
    @XmlElementAnno
    @ApiModelProperty("预约成功数")
    private String reserveCount;

    @XmlElement(name="canCount")
    @XmlElementAnno
    @ApiModelProperty("可借  一卡通证：分本地和云端剩余可借数 非一卡通统一返回数字")
    private String canCount;

    @XmlElement(name="loanCount")
    @XmlElementAnno
    @ApiModelProperty("已借  一卡通证：分本地和云端剩余可借数 非一卡通统一返回数字")
    private String loanCount;

    @XmlElement(name="notes")
    @XmlElementAnno
    @ApiModelProperty("备注")
    private String notes;

    @XmlElement(name="regdate")
    @XmlElementAnno
    @ApiModelProperty("注册日期")
    private String regdate;

    @XmlElement(name="enddate")
    @XmlElementAnno
    @ApiModelProperty("有效日期")
    private String enddate;

    @XmlElement(name="ecardtype")
    @XmlElementAnno
    @ApiModelProperty("云服务")
    private String ecardtype;

    @XmlElement(name="equipvalue")
    @XmlElementAnno
    @ApiModelProperty("设备号")
    private String equipvalue;

    @XmlElement(name="cardno")
    @XmlElementAnno
    @ApiModelProperty("卡号")
    private String cardno;

}
