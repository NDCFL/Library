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
//馆藏信息
public class CollectionBookRootVo implements Serializable {
    @XmlElement(name="code")
    @XmlElementAnno
    @ApiModelProperty("返回code   失败：0  成功 ：1")
    private Integer code;

    @XmlElement(name="pageNo")
    @XmlElementAnno
    @ApiModelProperty("当前页")
    private Integer pageNo;

    @XmlElement(name="pageSize")
    @XmlElementAnno
    @ApiModelProperty("页条数")
    private Integer pageSize;

    @XmlElement(name="text")
    private List<CollectionBooksVo> text;

}
