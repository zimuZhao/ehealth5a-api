package api.dao.impl;

import api.dao.UserAssociateFamilyDao;
import api.dao.base.BaseDaoImpl;
import api.model.UserAssociateFamily;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库表t_user_associate_family的Dao实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@Repository
public class UserAssociateFamilyDaoImpl extends BaseDaoImpl<UserAssociateFamily> implements UserAssociateFamilyDao {

    @Override
    public int insert(UserAssociateFamily t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(UserAssociateFamily t) throws Exception {
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
    public UserAssociateFamily findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<UserAssociateFamily> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<UserAssociateFamily> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<UserAssociateFamily> findFamilyById(Object id) throws Exception {
        String where = "WHERE userID =  '" + id + "'OR familyID = '" + id + "'";
        return super.findWhere(where);
    }

    @Override
    public List<UserAssociateFamily> findAssociation(Object senderId, Object receiverId) throws Exception {
        String where = "WHERE (userID='" + senderId + "' AND familyID='" + receiverId + "') OR (userID='" + receiverId + "' AND familyID='" + senderId + "')";
        return super.findWhere(where);
    }

}

