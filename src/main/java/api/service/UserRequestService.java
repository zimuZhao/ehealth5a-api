package api.service;

import api.model.UserRequest;
import api.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 数据库表t_user_request的Service接口层
 *
 * @author zimu
 * @date 2017-01-01 10:23:24 中国标准时间
 */
public interface UserRequestService extends BaseService<UserRequest> {

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(UserRequest model) throws Exception;

    /**
     * 根据ID删除
     *
     * @param id 主键ID
     */
    int delete(Object id) throws Exception;

    /**
     * 更新一条数据
     *
     * @param model 需要更新数据
     * @return 改变行数
     */
    int update(UserRequest model) throws Exception;

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
    UserRequest findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<UserRequest> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<UserRequest> findByPage(int limit, int start) throws Exception;

    /**
     * 根据ID查询发送的添加请求详情
     *
     * @param senderID 需要查询的ID
     * @return 全部所有数据
     */
    List<UserRequest> findSendById(Object senderID) throws Exception;

    /**
     * 根据ID查询接收的添加请求详情
     *
     * @param receiverID 需要查询的ID
     * @return 全部所有数据
     */
    Map<String,Object> findReceiveById(Object receiverID) throws Exception;

}
