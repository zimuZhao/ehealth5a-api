package api.dao.impl;

import api.dao.UserRequestDao;
import api.dao.base.BaseDaoImpl;
import api.model.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库表t_user_request的Dao实现
 *
 * @author zimu
 * @date 2017-01-01 10:23:23 中国标准时间
 */
@Repository
public class UserRequestDaoImpl extends BaseDaoImpl<UserRequest> implements UserRequestDao {

    @Override
    public int insert(UserRequest t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(UserRequest t) throws Exception {
        return super.update(t);
    }

    @Override
    public int delete(Object id) throws Exception {
        return super.delete(id);
    }

    @Override
    public int countAll() throws Exception {
        return super.countAll();
    }

    @Override
    public UserRequest findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<UserRequest> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<UserRequest> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<UserRequest> findSendById(Object senderID) throws Exception {
        String where = "WHERE senderID = '" + senderID + "'";
        return super.findWhere(where);
    }

    @Override
    public List<UserRequest> findReceiveById(Object receiverID) throws Exception {
        String where = "WHERE receiverID = '" + receiverID + "'";
        return super.findWhere(where);
    }
}

