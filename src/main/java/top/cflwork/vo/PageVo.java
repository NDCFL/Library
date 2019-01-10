package top.cflwork.vo;

import lombok.Data;

import java.util.List;
@Data
public class PageVo<T> {

	private Long total;
	private List<T> rows;


}
