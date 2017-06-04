package api.dao;

import api.dao.base.BaseDao;
import api.model.UserAssociateFamily;

import java.util.List;

/**
 * 数据库表t_user_associate_family的Dao接口
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
public interface UserAssociateFamilyDao extends BaseDao<UserAssociateFamily> {

    /**
     * 插入一条新数据
     *
     * @param model 添加的数据
     * @return 改变行数
     */
    int insert(UserAssociateFamily model) throws Exception;

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
    int update(UserAssociateFamily model) throws Exception;

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
    UserAssociateFamily findById(Object id) throws Exception;

    /**
     * 获取全部数据
     *
     * @return 全部所有数据
     */
    List<UserAssociateFamily> findAll() throws Exception;

    /**
     * 分页查询数据
     *
     * @param limit 分页最大值
     * @param start 开始编号
     * @return 分页列表数据
     */
    List<UserAssociateFamily> findByPage(int limit, int start) throws Exception;

    /**
     * 根据ID获取关联家庭成员
     *
     * @param id
     * @return 全部所有数据
     */
    List<UserAssociateFamily> findFamilyById(Object id) throws Exception;

    /**
     * 查找是否已存在关联关系
     *
     * @param senderId 发送方ID
     * @param receiverId 接收方ID
     * @return 全部所有数据
     */
    List<UserAssociateFamily> findAssociation(Object senderId, Object receiverId) throws Exception;

}
