package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SendVo implements Serializable{
    @ApiModelProperty("请求的ip地址")
    private String ip = "111.44.140.226";
    @ApiModelProperty("请求的端口号")
    private String port="8083";
    @ApiModelProperty("请求的路径")
    private String wsUrl;
    @ApiModelProperty("请求的命名空间")
    private String wsNameSpace = "http://impl.server.axis2.dlibs.com";
    @ApiModelProperty("请求的方法")
    private String method = "receive";
    @ApiModelProperty("请求的xml内容")
    private String xmlParams;
    @ApiModelProperty("请求的名称")
    private String name;
    @ApiModelProperty("请求的密码")
    private String pwd;
}
