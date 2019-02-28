package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

/**
 * 读者的兴趣爱好
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-02-28 14:08:14
 */
@Data
public class ReadUserBehaveVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("兴趣爱好编号")
    private String id;
    @ApiModelProperty("读者编号")
    private String readUserId;
    @ApiModelProperty("兴趣名称")
    private String title;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("分页对象")
    private Pager pager;
}
