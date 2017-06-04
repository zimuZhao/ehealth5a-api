package api.mapper;

import api.dao.base.BaseDaoMybatisMYSQLImpl.MybatisMultiDao;
import api.model.Nurse;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 数据库表t_nurse的mapper接口
 * @author zimu
 * @date 2016-12-30 21:15:50 中国标准时间
 */
public interface NurseMapper extends MybatisMultiDao<Nurse> {

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变的行数
	 */
	@Insert("INSERT INTO t_nurse ( nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber , intro , imgUrl , RES , description , deleteFlag ) VALUES ( #{nurseID} , #{userName} , #{password} , #{creatTime} , #{name} , #{sex} , #{age} , #{ethnic} , #{education} , #{birthPlace} , #{serviceType} , #{serviceArea} , #{workExperience} , #{ifStay} , #{pay} , #{mobile} , #{address} , #{addLng} , #{addLat} , #{iDNumber} , #{intro} , #{imgUrl} , #{rES} , #{description} , #{deleteFlag} )")
	int insert(Nurse model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 数据的主键ID
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_nurse WHERE nurseID=#{id}")
	int delete(@Param("id") Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 更新的数据
	 * @return 改变的行数
	 */
	@Update("UPDATE t_nurse SET nurseID=#{nurseID} , userName=#{userName} , password=#{password} , creatTime=#{creatTime} , name=#{name} , sex=#{sex} , age=#{age} , ethnic=#{ethnic} , education=#{education} , birthPlace=#{birthPlace} , serviceType=#{serviceType} , serviceArea=#{serviceArea} , workExperience=#{workExperience} , ifStay=#{ifStay} , pay=#{pay} , mobile=#{mobile} , address=#{address} , addLng=#{addLng} , addLat=#{addLat} , IDNumber=#{iDNumber} , intro=#{intro} , imgUrl=#{imgUrl} , RES=#{rES} , description=#{description} , deleteFlag=#{deleteFlag} WHERE nurseID=#{nurseID} ")
	int update(Nurse model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_nurse")
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse WHERE nurseID=#{id}")
	Nurse findById(@Param("id") Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部数据列表
	 */
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse ${order}")
	List<Nurse> findAll(@Param("order") String order) throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 分页列表数据
	 */
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse ${order} LIMIT ${start},${limit}")
	List<Nurse> findByPage(@Param("order") String order, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 选择性删除
	 * @param where SQL条件语句
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_nurse ${where}")
	int deleteWhere(@Param("where") String where) throws Exception;
	/**
	 * 选择性删除 - 假删 删除标记置为1
	 * @return 改变的行数
	 */
	@Update("UPDATE t_nurse SET deleteFlag=1 WHERE nurseID=#{id}")
	int remove(@Param("id") Object id) throws Exception;
	/**
	 * 根据属性值删除
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM t_nurse WHERE ${propertyName}=#{value}")
	int deleteByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
	/**
	 * 选择性统计
	 * @param where SQL条件语句
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM t_nurse ${where}")
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
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse ${where} ${order}")
	List<Nurse> findWhere(@Param("order") String order, @Param("where") String where) throws Exception;
	/**
	 * 选择性分页查询
	 * @param where SQL条件语句
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse ${where} ${order} LIMIT ${start},${limit}")
	List<Nurse> findWhereByPage(@Param("order") String order, @Param("where") String where, @Param("limit") int limit, @Param("start") int start) throws Exception;
	/**
	 * 根据属性查询
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 返回符合条件的数据列表
	 */
	@Select("SELECT nurseID , userName , password , creatTime , name , sex , age , ethnic , education , birthPlace , serviceType , serviceArea , workExperience , ifStay , pay , mobile , address , addLng , addLat , IDNumber iDNumber , intro , imgUrl , RES rES , description , deleteFlag FROM t_nurse WHERE ${propertyName}=#{value} ${order}")
	List<Nurse> findByPropertyName(@Param("order") String order, @Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;
}