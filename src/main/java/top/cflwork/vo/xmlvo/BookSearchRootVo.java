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
/**
 * 图书检索
 */
public class BookSearchRootVo implements Serializable {
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
    private List<BookSearchVo> text;

    @XmlElement(name="totalCount")
    @XmlElementAnno
    private Long totalCount;

    @ApiModelProperty(value = "type的类型有：all（所有词） ,title（标题）,author（作者）,publisher（出版社）,ctrlno（控制号）,subject（主题）,isbn（isbn号）,callno（书架号）,classno（分类号）,参数必填",required = true)
    private String searchType;

    @ApiModelProperty(value = "搜索内容,参数必填",required =true)
    private String searchValue;

    @ApiModelProperty(value = "图书馆编号",required = true)
    private String libraryId;


}
