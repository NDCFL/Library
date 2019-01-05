package top.cflwork.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageVo<T> {

	private int pageIndex;
	private int pageSize;
	private int total;
	private Map<String, Object> params;
	private String param;
	private List<T> rows;

	public PageVo() {
		super();
		this.pageIndex = 0;
		this.pageSize = 10;
		this.total = 1;
		this.params = new HashMap<>();
		this.param = "";
		this.rows = new ArrayList<>();
	}

	public int getOffset() {
		return pageIndex;
	}

	public void setOffset(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return "PageVo{" +
				"pageIndex=" + pageIndex +
				", pageSize=" + pageSize +
				", total=" + total +
				", params=" + params +
				", param='" + param + '\'' +
				", rows=" + rows +
				'}';
	}
}
