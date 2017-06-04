package api.service.base;

import api.dao.base.BaseDao;
import api.util.Page;

/**
 * 通用Service层接口
 * @param <T>
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
public interface BaseService<T> extends BaseDao<T>{
	int delete(String id) throws Exception;
	T findById(String id) throws Exception;
	Page<T> listByPage(int pageSize, int pageNo) throws Exception;
}
