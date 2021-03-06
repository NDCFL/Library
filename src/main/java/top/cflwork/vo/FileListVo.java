package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import top.cflwork.common.Pager;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 *
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-19 16:02:20
 */
public class FileListVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String id;
    // 文件类型
    private Integer type;
    // URL地址
    private String url;
    // 创建时间
    private Date createDate;
    @ApiModelProperty("分页对象")
    private Pager pager;
    private String ids[];

    public FileListVo() {
        super();
    }


    public FileListVo(Integer type, String url, Date createDate) {
        super();
        this.type = type;
        this.url = url;
        this.createDate = createDate;
    }


    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：文件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：文件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置：URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：URL地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "FileListVo{" +
                "id=" + id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
