package api.dao.impl;

import java.util.List;
import java.util.Map;

import api.mapper.DataBloodOxygenMapper;
import api.model.DataBloodGlucose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.DataBloodOxygenDao;
import api.model.DataBloodOxygen;

/**
 * 数据库表t_data_blood_oxygen的Dao实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class DataBloodOxygenDaoImpl extends BaseDaoImpl<DataBloodOxygen> implements DataBloodOxygenDao {

    @Autowired
    DataBloodOxygenMapper dataBloodOxygenMapper;

    @Override
    public int insert(DataBloodOxygen t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(DataBloodOxygen t) throws Exception {
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
        String where = "WHERE measureTime >= '" + start + "' and measureTime< '" + end + "'";
        return dataBloodOxygenMapper.countWhere(where);
    }

    @Override
    public  int countByTimeWhere(String start, String end, String conditions) throws  Exception{
        String where = "WHERE measureTime >= '" + start + "' and measureTime< '" + end + "' and " + conditions;
        return dataBloodOxygenMapper.countWhere(where);
    }

    @Override
    public DataBloodOxygen findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<DataBloodOxygen> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<DataBloodOxygen> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<DataBloodOxygen> findByUserID(Object userID) throws Exception {
        String where = "WHERE associateID = ANY(SELECT associateID FROM t_user_associate_device WHERE userID =  '" + userID + "')ORDER BY measureTime DESC";
        return super.findWhere(where);
    }

    @Override
    public DataBloodOxygen findByRecentTime(Object userID) throws Exception {
        return dataBloodOxygenMapper.findByRecentTime(userID);
    }

    @Override
    public List<Map<String, Object>> findIntervalCount(Object interval, Object cut) throws Exception {
        return dataBloodOxygenMapper.findIntervalCount(interval, cut);
    }

    @Override
    public List<Map<String, Object>> findIntervalCountWhere(Object interval, Object cut, Object where) throws Exception {
        return dataBloodOxygenMapper.findIntervalCountWhere(interval, cut, where);
    }
}

