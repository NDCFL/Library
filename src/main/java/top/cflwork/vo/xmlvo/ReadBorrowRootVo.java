package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ReadBorrowRootVo {
    @XmlElement(name="code")
    @XmlElementAnno
    @ApiModelProperty("返回code   失败：0  成功 ：1")
    private Integer code;

    @XmlElement(name="text")
    private List<ReadBorrowVo> text;

    @XmlElement(name="pageNo")
    @XmlElementAnno
    @ApiModelProperty("当前页")
    private String pageNo;

    @XmlElement(name="pageSize")
    @XmlElementAnno
    @ApiModelProperty("当前页大小")
    private String pageSize;

    @XmlElement(name="totalCount")
    @XmlElementAnno
    @ApiModelProperty("总记录数")
    private String totalCount;

    @ApiModelProperty(value = "卡号",required = true)
    private  String cardno;

    @ApiModelProperty(value = "起始时间",required = true)
    private  String startDate;

    @ApiModelProperty(value = "结束时间",required = true)
    private  String endDate;


}
