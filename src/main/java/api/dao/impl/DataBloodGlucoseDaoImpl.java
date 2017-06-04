package api.dao.impl;

import java.util.List;
import java.util.Map;

import api.mapper.DataBloodGlucoseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.DataBloodGlucoseDao;
import api.model.DataBloodGlucose;

/**
 * 数据库表t_data_blood_glucose的Dao实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class DataBloodGlucoseDaoImpl extends BaseDaoImpl<DataBloodGlucose> implements DataBloodGlucoseDao {

    @Autowired
    DataBloodGlucoseMapper dataBloodGlucoseMapper;

    @Override
    public int insert(DataBloodGlucose t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(DataBloodGlucose t) throws Exception {
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
        return dataBloodGlucoseMapper.countWhere(where);
    }

    @Override
    public  int countByTimeWhere(String start, String end, String conditions) throws  Exception{
        String where = "WHERE measureTime >= '" + start + "' and measureTime< '" + end + "' and " + conditions;
        return dataBloodGlucoseMapper.countWhere(where);
    }

    @Override
    public DataBloodGlucose findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<DataBloodGlucose> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<DataBloodGlucose> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<DataBloodGlucose> findByUserID(Object userID) throws Exception {
        String where = "WHERE associateID = ANY(SELECT associateID FROM t_user_associate_device WHERE userID =  '" + userID + "')ORDER BY measureTime DESC";
        return super.findWhere(where);
    }

    @Override
    public DataBloodGlucose findByRecentTime(Object userID) throws Exception {
        return dataBloodGlucoseMapper.findByRecentTime(userID);
    }

    @Override
    public List<Map<String, Object>> findIntervalCount(Object interval, Object cut) throws Exception {
        return dataBloodGlucoseMapper.findIntervalCount(interval, cut);
    }

    @Override
    public List<Map<String, Object>> findIntervalCountWhere(Object interval, Object cut, Object where) throws Exception {
        return dataBloodGlucoseMapper.findIntervalCountWhere(interval, cut, where);
    }
}

