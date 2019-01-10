package top.cflwork.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author cflworks 275300091@qq.com
 */
@Data
public class  PageUtils<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long total;
	private List<T> rows;

	public PageUtils(List<T> list, Long total) {
		this.rows = list;
		this.total = total;
	}

}
