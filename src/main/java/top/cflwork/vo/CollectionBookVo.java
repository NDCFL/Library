package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.util.Date;

/**
 * 馆藏表
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-11 13:23:06
 */
@Data
public class CollectionBookVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("编号")
    private String id;
    @ApiModelProperty("条码号")
    private String barcode;
    @ApiModelProperty("索书号")
    private String callno;
    @ApiModelProperty("还回日期")
    private Date retudate;
    @ApiModelProperty("入馆时间")
    private Date regdate;
    @ApiModelProperty("书架位置")
    private String shiftno;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("原分馆")
    private String sublib;
    @ApiModelProperty("原馆藏地点")
    private String local;
    @ApiModelProperty("当前分馆")
    private String cursublib;
    @ApiModelProperty("当前馆藏地点")
    private String curlocal;
    @ApiModelProperty("价格（单位：分）")
    private Double price;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
