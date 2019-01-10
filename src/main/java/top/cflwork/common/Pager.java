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
    private int pageIndex;
    // 每页条数
    private int pageSize;
    //排序字段
    private String sort;
    //排序方式
    private String order;

    public int getPageIndex() {
        return (pageIndex-1)*pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
