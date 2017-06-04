package api.mapper;

import api.dao.base.BaseDaoMybatisMYSQLImpl.MybatisMultiDao;
import api.model.UserRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 数据库表t_user_request的mapper接口
 * @author zimu
 * @date 2017-01-01 10:23:23 中国标准时间
 */
public interface UserRequestMapper extends MybatisMultiDao<UserRequest> {

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变的行数
	 */
	@Insert("INSERT INTO t_user_request ( requestID , senderID , receiverID , creatTime , status , RES , description , deleteFlag ) VALUES ( #{requestID} , #{senderID} , #{receiverID} , #{creatTime} , #{status} , #{rES} , #{description} , #{deleteFlag} )")
	int insert(UserRequest model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 数据的主键ID
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_user_request WHERE requestID=#{id}")
	int delete(@Param("id") Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 更新的数据
	 * @return 改变的行数
	 */
	@Update("UPDATE t_user_request SET requestID=#{requestID} , senderID=#{senderID} , receiverID=#{receiverID} , creatTime=#{creatTime} , status=#{status} , RES=#{rES} , description=#{description} , deleteFlag=#{deleteFlag} WHERE requestID=#{requestID} ")
	int update(UserRequest model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_user_request")
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request WHERE requestID=#{id}")
	UserRequest findById(@Param("id") Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部数据列表
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request ${order}")
	List<UserRequest> findAll(@Param("order") String order) throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 分页列表数据
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request ${order} LIMIT ${start},${limit}")
	List<UserRequest> findByPage(@Param("order") String order, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 选择性删除
	 * @param where SQL条件语句
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_user_request ${where}")
	int deleteWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性值删除
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_user_request WHERE ${propertyName}=#{value}")
	int deleteByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
	/**
	 * 选择性统计
	 * @param where SQL条件语句
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_user_request ${where}")
	int countWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性统计
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM WHERE ${propertyName}=#{value}")
	int countByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
	/**
	 * 选择性查询
	 * @param where SQL条件语句
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request ${where} ${order}")
	List<UserRequest> findWhere(@Param("order") String order, @Param("where") String where) throws Exception;
	/**
	 * 选择性分页查询
	 * @param where SQL条件语句
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request ${where} ${order} LIMIT ${start},${limit}")
	List<UserRequest> findWhereByPage(@Param("order") String order, @Param("where") String where, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 根据属性查询
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 返回符合条件的数据列表
	 */
	@Select("SELECT requestID , senderID , receiverID , creatTime , status , RES rES , description , deleteFlag FROM t_user_request WHERE ${propertyName}=#{value} ${order}")
	List<UserRequest> findByPropertyName(@Param("order") String order, @Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
}