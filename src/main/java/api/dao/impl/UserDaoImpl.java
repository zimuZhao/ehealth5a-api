package api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.UserDao;
import api.model.User;

/**
 * 数据库表t_user的Dao实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public int insert(User t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(User t) throws Exception {
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
    public int countByTime(String start, String end) throws Exception {
        String where = "WHERE creatTime >= '" + start + "' and creatTime< '" + end + "'";
        return super.countWhere(where);
    }

    @Override
    public User findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<User> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<User> findByUsername(String username) throws Exception {
        String where = "WHERE username = '" + username + "'";
        return super.findWhere(where);
    }
}

