package api.dao;

import api.dao.base.BaseDao;
import api.model.Nurse;

import java.util.List;

/**
 * 数据库表t_nurse的Dao接口
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
public interface NurseDao extends BaseDao<Nurse> {

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
     * @return 改变行数
     */
    int delete(Object id) throws Exception;

    /**
     * 根据ID删除 - 假删
     *
     * @param id 主键ID
     * @return 改变行数
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
     * 统计全部删除标记为0的数据
     *
     * @return 全部数据量
     */
    int countDeleteIsFalse() throws Exception;

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
     * 获取全部删除标记为0的数据
     *
     * @return 全部所有数据
     */
    List<Nurse> findDeleteIsFalse() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<Nurse> findByPage(int limit, int start) throws Exception;

    /**
     * 分页查询删除标记为0的数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<Nurse> findByPageDeleteIsFalse(int limit, int start) throws Exception;

}
