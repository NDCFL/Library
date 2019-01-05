package top.cflwork.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 
	private int pageIndex;
	// 每页条数
	private int pageSize;
	//排序字段
	private String sort;
	//排序方式
	private String order;
	public Query(Map<String, Object> params) {
		this.putAll(params);
		// 分页参数
		this.pageIndex = Integer.parseInt(params.get("pageIndex").toString());
		this.pageSize = Integer.parseInt(params.get("pageSize").toString());
		this.put("pageIndex", pageIndex);
		this.put("page", pageIndex / pageSize + 1);
		this.put("pageSize", pageSize);
		this.put("sort",sort);
		this.put("order",order);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.put("pageIndex", pageIndex);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
