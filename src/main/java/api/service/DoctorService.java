package api.service;

import api.model.Doctor;
import api.model.User;
import api.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 数据库表t_doctor的Service接口层
 *
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
public interface DoctorService extends BaseService<Doctor> {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    Doctor login(String username, String password) throws Exception;

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(Doctor model) throws Exception;

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
    int update(Doctor model) throws Exception;

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
    Doctor findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<Doctor> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<Doctor> findByPage(int limit, int start) throws Exception;

    /**
     * 根据ID获取患者列表
     *
     * @param id 主键ID
     * @return 数据对象 or null
     */
    Map<String, Object> findUserById(Object id) throws Exception;

}
