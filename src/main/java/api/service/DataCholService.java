package api.service;

import java.util.List;

import api.model.DataChol;
import api.service.base.BaseService;

/**
 * 数据库表t_data_chol的Service接口层
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
public interface DataCholService extends BaseService<DataChol> {

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变行数
	 */
	int insert(DataChol model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 主键ID
	 */
	int delete(Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 需要更新数据
	 * @return 改变行数
	 */
	int update(DataChol model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 全部数据量
	 */
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return 数据对象 or null
	 */
	DataChol findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部所有数据
	 */
	List<DataChol> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 分页最大值
	 * @param start 开始编号
	 * @return 分页列表数据
	 */
	List<DataChol> findByPage(int limit,int start) throws Exception;
	/**
	 * 根据用户ID获取当前用户所有记录
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	List<DataChol> findByUserID(Object userID) throws Exception;
}
