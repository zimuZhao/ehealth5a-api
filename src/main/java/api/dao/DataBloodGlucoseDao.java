package api.dao;

import java.util.List;
import java.util.Map;

import api.dao.base.BaseDao;
import api.model.DataBloodGlucose;
import org.apache.ibatis.annotations.Param;

/**
 * 数据库表t_data_blood_glucose的Dao接口
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
public interface DataBloodGlucoseDao extends BaseDao<DataBloodGlucose> {

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(DataBloodGlucose model) throws Exception;

    /**
     * 根据ID删除
     *
     * @param id 主键ID
     * @return 改变行数
     */
    int delete(Object id) throws Exception;

    /**
     * 更新一条数据
     *
     * @param model 需要更新数据
     * @return 改变行数
     */
    int update(DataBloodGlucose model) throws Exception;

    /**
     * 统计全部出数据
     *
     * @return 全部数据量
     */
    int countAll() throws Exception;

    /**
     * 统计时间区间内数据
     *
     * @return 全部数据量
     */
    int countByTime(String start, String end) throws Exception;

    /**
     * 统计时间区间内满足条件数据
     *
     * @return 全部数据量
     */
    int countByTimeWhere(String start, String end, String conditions) throws Exception;

    /**
     * 根据ID获取
     *
     * @param id 主键ID
     * @return 数据对象 or null
     */
    DataBloodGlucose findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<DataBloodGlucose> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<DataBloodGlucose> findByPage(int limit, int start) throws Exception;

    /**
     * 根据用户ID获取所有记录
     *
     * @param userID
     * @return
     * @throws Exception
     */
    List<DataBloodGlucose> findByUserID(Object userID) throws Exception;

    /**
     * 根据用户ID获取最新记录
     *
     * @param userID
     * @return
     * @throws Exception
     */
    DataBloodGlucose findByRecentTime(Object userID) throws Exception;

    /**
     * 区间数据量统计
     * @param interval
     * @param cut
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> findIntervalCount(Object interval,Object cut) throws Exception;

    /**
     * 区间数据量条件统计
     * @param interval
     * @param cut
     * @param where
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> findIntervalCountWhere(Object interval,Object cut,Object where) throws Exception;
}
