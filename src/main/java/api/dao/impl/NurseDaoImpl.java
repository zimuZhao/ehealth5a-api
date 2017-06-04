package api.dao.impl;

import api.dao.NurseDao;
import api.dao.base.BaseDaoImpl;
import api.mapper.NurseMapper;
import api.model.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库表t_nurse的Dao实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@Repository
public class NurseDaoImpl extends BaseDaoImpl<Nurse> implements NurseDao {

    @Autowired
    NurseMapper nurseMapper;

    @Override
    public int insert(Nurse t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(Nurse t) throws Exception {
        return super.update(t);
    }

    @Override
    public int delete(Object id) throws Exception {
        return super.delete(id);
    }

    @Override
    public int remove(Object id) throws Exception {
        return nurseMapper.remove(id);
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
    public Nurse findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<Nurse> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<Nurse> findDeleteIsFalse() throws Exception {
        return super.findWhere("WHERE deleteFlag=0");
    }

    @Override
    public List<Nurse> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<Nurse> findByPageDeleteIsFalse(int limit, int start) throws Exception {
        return super.findWhereByPage("WHERE deleteFlag=0", limit, start);
    }
}

