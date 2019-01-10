package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.io.Serializable;
import java.util.Map;

public class FileVo implements Serializable{
    private int code;
    private String msg;
    private Map<String,String> data;
    private String ids[];
    @ApiModelProperty("分页对象")
    private Pager pager;
    public int getCode() {
        return code;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
