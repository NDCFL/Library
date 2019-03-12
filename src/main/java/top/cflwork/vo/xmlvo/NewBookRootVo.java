package top.cflwork.vo.xmlvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.cflwork.common.XmlElementAnno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class NewBookRootVo  implements Serializable {
    @XmlElement(name="code")
    @XmlElementAnno
    @ApiModelProperty("返回code   失败：0  成功 ：1")
    private Integer code;

    @XmlElement(name="totalCount")
    @XmlElementAnno
    @ApiModelProperty("总记录数")
    private Integer totalCount;

    @XmlElement(name="text")
    private List<NewBooksVo> text;

    @ApiModelProperty(value = "起始时间",required = true)
    private String startDate;
    @ApiModelProperty(value = "结束时间",required = true)
    private String endDate;
    @ApiModelProperty(value = "分馆",required = true)
    private String sublib = "QHL";
    @ApiModelProperty(value = "当前页",required = true)
    private String pageNo;
    @ApiModelProperty(value = "页条数",required = true)
    private String pageSize;


}
