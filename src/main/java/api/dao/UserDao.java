package api.dao;

import java.util.List;

import api.dao.base.BaseDao;
import api.model.User;

/**
 * 数据库表t_user的Dao接口
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
public interface UserDao extends BaseDao<User>{

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变行数
	 */
	int insert(User model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 主键ID
	 * @return 改变行数
	 */
	int delete(Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 需要更新数据
	 * @return 改变行数
	 */
	int update(User model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 全部数据量
	 */
	int countAll() throws Exception;
	/**
	 * 统计时间段内数据量
	 * @return 全部数据量
	 */
	int countByTime(String start, String end) throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return 数据对象 or null
	 */
	User findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部所有数据
	 */
	List<User> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 分页最大值
	 * @param start 开始编号
	 * @return 分页列表数据
	 */
	List<User> findByPage(int limit,int start) throws Exception;

	/**
	 *
	 * @param username
	 * @return
	 * @throws Exception
	 */
	List<User> findByUsername(String username) throws Exception;
	

}
