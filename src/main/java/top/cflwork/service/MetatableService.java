package top.cflwork.service;

import top.cflwork.vo.MetatableVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import top.cflwork.vo.xmlvo.BookSearchVo;
import top.cflwork.vo.xmlvo.MetaTablesVo;

/**
 * 图书书目信息表
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 16:50:26
 */
@Service
public interface MetatableService {

	MetatableVo get(String id);

	List<MetatableVo> list(MetatableVo metatableVo);

	long count(MetatableVo metatableVo);

	int save(MetatableVo metatable);

	int update(MetatableVo metatable);

	int remove(String id);

	int batchRemove(String[] ids);

	int batchSave(List<MetatableVo> metatableList);

	int batchSaveBook(List<BookSearchVo> bookSearchVoList);

	int updateBook(MetaTablesVo metaTablesVo);
}
