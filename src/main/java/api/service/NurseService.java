package api.service;

import api.model.Nurse;
import api.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 数据库表t_nurse的Service接口层
 *
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
public interface NurseService extends BaseService<Nurse> {

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(Nurse model) throws Exception;

    /**
     * 根据ID删除
     *
     * @param id 主键ID
     */
    int delete(Object id) throws Exception;

    /**
     * 根据ID删除 - 假删
     *
     * @param id 主键ID
     */
    int remove(Object id) throws Exception;

    /**
     * 更新一条数据
     *
     * @param model 需要更新数据
     * @return 改变行数
     */
    int update(Nurse model) throws Exception;

    /**
     * 统计全部出数据
     *
     * @return 全部数据量
     */
    int countAll() throws Exception;

    /**
     * 根据ID获取
     *
     * @param id 主键ID
     * @return 数据对象 or null
     */
    Nurse findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<Nurse> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<Nurse> findByPage(int limit, int start) throws Exception;

    /**
     * 根据用户经纬度按距离由近到远排序 - 此处检索范围是整表所有护工的经纬度，后续应优化检索范围
     *
     * @param lat 用户经度
     * @param lng 用户纬度
     * @return 排序后的护工列表
     */
    Map<String, Object> sortByDistance(double lat, double lng) throws Exception;

}
