package api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import api.model.DataUricCid;
import api.dao.base.BaseDaoMybatisMYSQLImpl.MybatisMultiDao;


/**
 * 数据库表t_data_uric_cid的mapper接口
 * @author zimu
 * @date 2016-11-05 15:26:20 中国标准时间
 */
public interface DataUricCidMapper extends MybatisMultiDao<DataUricCid>{

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变的行数
	 */
	@Insert("INSERT INTO t_data_uric_cid ( uaID , associateID , measureTime , UA , upload , RES , creatTime , describtion , deleteFlag ) VALUES ( #{uaID} , #{associateID} , #{measureTime} , #{uA} , #{upload} , #{rES} , #{creatTime} , #{describtion} , #{deleteFlag} )")
	int insert(DataUricCid model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 数据的主键ID
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_data_uric_cid WHERE uaID=#{id}")
	int delete(@Param("id") Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 更新的数据
	 * @return 改变的行数
	 */
	@Update("UPDATE t_data_uric_cid SET uaID=#{uaID} , associateID=#{associateID} , measureTime=#{measureTime} , UA=#{uA} , upload=#{upload} , RES=#{rES} , creatTime=#{creatTime} , describtion=#{describtion} , deleteFlag=#{deleteFlag} WHERE uaID=#{uaID} ")
	int update(DataUricCid model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_data_uric_cid")
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid WHERE uaID=#{id}")
	DataUricCid findById(@Param("id") Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部数据列表
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid ${order}")
	List<DataUricCid> findAll(@Param("order") String order) throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 分页列表数据
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid ${order} LIMIT ${start},${limit}")
	List<DataUricCid> findByPage(@Param("order") String order,@Param("limit") int limit,@Param("start") int start) throws Exception;
	/**
	 * 选择性删除
	 * @param where SQL条件语句
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_data_uric_cid ${where}")
	int deleteWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性值删除
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_data_uric_cid WHERE ${propertyName}=#{value}")
	int deleteByPropertyName(@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;
	/**
	 * 选择性统计
	 * @param where SQL条件语句
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_data_uric_cid ${where}")
	int countWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性统计
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM WHERE ${propertyName}=#{value}")
	int countByPropertyName(@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;
	/**
	 * 选择性查询
	 * @param where SQL条件语句
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid ${where} ${order}")
	List<DataUricCid> findWhere(@Param("order") String order,@Param("where") String where) throws Exception;
	/**
	 * 选择性分页查询
	 * @param where SQL条件语句
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid ${where} ${order} LIMIT ${start},${limit}")
	List<DataUricCid> findWhereByPage(@Param("order") String order,@Param("where") String where,@Param("limit") int limit,@Param("start") int start) throws Exception;
	/**
	 * 根据属性查询
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 返回符合条件的数据列表
	 */
	@Select("SELECT uaID , associateID , measureTime , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid WHERE ${propertyName}=#{value} ${order}")
	List<DataUricCid> findByPropertyName(@Param("order") String order,@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;

	/**
	 * 根据ID获取当前用户最新记录
	 *
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT uaID , associateID , MAX(measureTime) , UA uA , upload , RES rES , creatTime , describtion , deleteFlag FROM t_data_uric_cid WHERE associateID = ANY(SELECT associateID FROM t_user_associate_device WHERE userID =#{id} )")
	DataUricCid findByRecentTime(@Param("id") Object id) throws Exception;

	/**
	 * 区间数据量统计
	 *
	 * @param interval 区间 - 2016-11%（按日） 2016%（按月） %(按年)
	 * @param cut      截取字段 - 10(按日) 7（按月） 4（按年）
	 * @return null 或者 查询后的数据集合
	 */
	@Select("select substr(measureTime,1,#{cut}) as measureTime,count(measureTime) as num from t_data_uric_cid where measureTime like #{interval} group by substr(measureTime,1,#{cut})")
	List<Map<String, Object>> findIntervalCount(@Param("interval") Object interval, @Param("cut") Object cut) throws Exception;

	/**
	 * 区间数据量条件统计
	 *
	 * @param interval 区间 - 2016-11%（按日） 2016%（按月） %(按年)
	 * @param cut      截取字段 - 10(按日) 7（按月） 4（按年）
	 * @param where    条件
	 * @return null 或者 查询后的数据集合
	 */
	@Select("select substr(measureTime,1,#{cut}) as measureTime,count(measureTime) as num from t_data_uric_cid where measureTime like #{interval} and ${where} group by substr(measureTime,1,#{cut})")
	List<Map<String, Object>> findIntervalCountWhere(@Param("interval") Object interval, @Param("cut") Object cut, @Param("where") Object where) throws Exception;
}