package api.dao.impl;

import api.dao.UserAssociateDoctorDao;
import api.dao.base.BaseDaoImpl;
import api.mapper.UserAssociateDoctorMapper;
import api.model.UserAssociateDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库表t_user_associate_doctor的Dao实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@Repository
public class UserAssociateDoctorDaoImpl extends BaseDaoImpl<UserAssociateDoctor> implements UserAssociateDoctorDao {

    @Autowired
    UserAssociateDoctorMapper userAssociateDoctorMapper;

    @Override
    public int insert(UserAssociateDoctor t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(UserAssociateDoctor t) throws Exception {
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
    public UserAssociateDoctor findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<UserAssociateDoctor> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<UserAssociateDoctor> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<String> findUserIdByDoctorId(Object id) throws Exception {
        return userAssociateDoctorMapper.findUserIdByDoctorId(id);
    }
}

