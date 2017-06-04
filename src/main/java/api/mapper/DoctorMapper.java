package api.mapper;

import api.dao.base.BaseDaoMybatisMYSQLImpl.MybatisMultiDao;
import api.model.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 数据库表t_doctor的mapper接口
 * @author zimu
 * @date 2016-12-30 21:15:50 中国标准时间
 */
public interface DoctorMapper extends MybatisMultiDao<Doctor> {

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变的行数
	 */
	@Insert("INSERT INTO t_doctor ( doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber , intro , imgUrl , RES , description , deleteFlag ) VALUES ( #{doctorID} , #{userName} , #{password} , #{creatTime} , #{name} , #{sex} , #{age} , #{education} , #{direction} , #{rate} , #{workExperience} , #{license} , #{pay} , #{mobile} , #{address} , #{addLng} , #{addLat} , #{iDNumber} , #{intro} , #{imgUrl} , #{rES} , #{description} , #{deleteFlag} )")
	int insert(Doctor model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 数据的主键ID
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_doctor WHERE doctorID=#{id}")
	int delete(@Param("id") Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 更新的数据
	 * @return 改变的行数
	 */
	@Update("UPDATE t_doctor SET doctorID=#{doctorID} , userName=#{userName} , password=#{password} , creatTime=#{creatTime} , name=#{name} , sex=#{sex} , age=#{age} , education=#{education} , direction=#{direction} , rate=#{rate} , workExperience=#{workExperience} , license=#{license} , pay=#{pay} , mobile=#{mobile} , address=#{address} , addLng=#{addLng} , addLat=#{addLat} , IDNumber=#{iDNumber} , intro=#{intro} , imgUrl=#{imgUrl} , RES=#{rES} , description=#{description} , deleteFlag=#{deleteFlag} WHERE doctorID=#{doctorID} ")
	int update(Doctor model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_doctor")
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor WHERE doctorID=#{id}")
	Doctor findById(@Param("id") Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部数据列表
	 */
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor ${order}")
	List<Doctor> findAll(@Param("order") String order) throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 分页列表数据
	 */
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor ${order} LIMIT ${start},${limit}")
	List<Doctor> findByPage(@Param("order") String order, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 选择性删除
	 * @param where SQL条件语句
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_doctor ${where}")
	int deleteWhere(@Param("where") String where) throws Exception;
	/**
	 * 选择性删除 - 假删 删除标记置为1
	 * @return 改变的行数
	 */
	@Update("UPDATE t_doctor SET deleteFlag=1 WHERE doctorID=#{id}")
	int remove(@Param("id") Object id) throws Exception;
	/**
	 * 根据属性值删除
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_doctor WHERE ${propertyName}=#{value}")
	int deleteByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
	/**
	 * 选择性统计
	 * @param where SQL条件语句
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_doctor ${where}")
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
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor ${where} ${order}")
	List<Doctor> findWhere(@Param("order") String order, @Param("where") String where) throws Exception;
	/**
	 * 选择性分页查询
	 * @param where SQL条件语句
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor ${where} ${order} LIMIT ${start},${limit}")
	List<Doctor> findWhereByPage(@Param("order") String order, @Param("where") String where, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 根据属性查询
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 返回符合条件的数据列表
	 */
	@Select("SELECT doctorID , userName , password , creatTime , name , sex , age , education , direction , rate , workExperience , license , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_doctor WHERE ${propertyName}=#{value} ${order}")
	List<Doctor> findByPropertyName(@Param("order") String order, @Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
}