package api.dao.impl;

import api.dao.DoctorDao;
import api.dao.base.BaseDaoImpl;
import api.mapper.DoctorMapper;
import api.mapper.NurseMapper;
import api.model.Doctor;
import api.model.Nurse;
import api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库表t_doctor的Dao实现
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@Repository
public class DoctorDaoImpl extends BaseDaoImpl<Doctor> implements DoctorDao {

    @Autowired
    DoctorMapper doctorMapper;

	@Override
	public int insert(Doctor t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(Doctor t) throws Exception {
		return super.update(t);
	}

	@Override
	public int delete(Object id) throws Exception {
		return super.delete(id);
	}

	@Override
	public int remove(Object id) throws Exception {
		return doctorMapper.remove(id);
	}

	@Override
	public int countAll() throws Exception {
		return super.countAll();
	}

    @Override
    public int countDeleteIsFalse() throws Exception {
        return super.countWhere("WHERE deleteFlag=0");
    }

	@Override
	public Doctor findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<Doctor> findAll() throws Exception {
		return super.findAll();
	}

    @Override
    public List<Doctor> findDeleteIsFalse() throws Exception {
        return super.findWhere("WHERE deleteFlag=0");
    }

	@Override
	public List<Doctor> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}

	@Override
	public List<Doctor> findByUsername(String username) throws Exception {
		String where = "WHERE username = '" + username + "'";
		return super.findWhere(where);
	}

    @Override
    public List<Doctor> findByPageDeleteIsFalse(int limit, int start) throws Exception {
        return super.findWhereByPage("WHERE deleteFlag=0", limit, start);
    }
}

