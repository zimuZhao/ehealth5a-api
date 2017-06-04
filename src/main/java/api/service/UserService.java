package api.service;

import java.util.List;
import java.util.Map;

import api.model.DataGroup;
import api.model.User;
import api.service.base.BaseService;

/**
 * 数据库表t_user的Service接口层
 *
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
public interface UserService extends BaseService<User> {

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(User model) throws Exception;

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
    int update(User model) throws Exception;

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
    User findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<User> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<User> findByPage(int limit, int start) throws Exception;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User login(String username, String password) throws Exception;

    /**
     * 获取当前用户最新所有健康信息
     *
     * @param userID
     * @return
     * @throws Exception
     */
    DataGroup findByRecentTime(Object userID) throws Exception;

    /**
     * 获取当前用户健康报告
     *
     * @param userID
     * @return
     * @throws Exception
     */
    Map<String, Object> getReport(Object userID) throws Exception;

    /**
     * 统计上月每个指标的上传总量
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> countByLastMonth() throws Exception;

    /**
     * 统计上月每天每个指标的上传数量
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> countByLastMonthDay() throws Exception;

    /**
     * 根据用户ID查找家庭成员的userID
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> findFamilyById(Object id) throws Exception;

    /**
     * 发送添加家庭成员的请求
     *
     * @param senderId   发送方ID
     * @param receiverId 接收方ID
     * @return 改变行数
     */
    String sendRequest(String senderId, String receiverId) throws Exception;

    /**
     * 处理添加家庭关系请求
     *
     * @param senderID   发送方ID
     * @param receiverID 接收方ID
     * @param state      反馈状态   false表示拒绝添加 true表示接收添加
     * @return
     * @throws Exception
     */
    String handleRequest(String senderID, String receiverID, String requestID, Boolean state) throws Exception;

    /**
     * 统计上个月异常指标趋势
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> anomalyTrendByLastMonth() throws Exception;

    /**
     * 罗列上个月易发疾病
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> anomalyListByLastMonth() throws Exception;

    /**
     * admin-index 头部四模块
     * 今日新增用户，总用户数 月异常指标，易发疾病 月覆盖区域，活跃区域，异常区域  数据上传今日，上周，上月
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> adminFourPart() throws Exception;
}
