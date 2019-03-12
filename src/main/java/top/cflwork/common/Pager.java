package top.cflwork.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("分页排序等支撑类,保存数据时请忽略,做条件查询时用")
@Data
public class Pager {
    @ApiModelProperty(value = "当前页",required = true)
    private int pageIndex;
    @ApiModelProperty(value = "页条数",required = true)
    private int pageSize;
    @ApiModelProperty(value = "排序字段",required = true)
    private String sort;
    @ApiModelProperty(value = "排序顺序，esc(顺序),desc(倒序)",required = true)
    private String order;

    private boolean paging = true;

    public int getPageIndex() {
        return (pageIndex-1)*pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
