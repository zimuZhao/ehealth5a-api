package api.dao.impl;

import java.util.List;
import java.util.Map;

import api.mapper.DataHemoglobinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.DataHemoglobinDao;
import api.model.DataHemoglobin;

/**
 * 数据库表t_data_hemoglobin的Dao实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class DataHemoglobinDaoImpl extends BaseDaoImpl<DataHemoglobin> implements DataHemoglobinDao {

    @Autowired
    DataHemoglobinMapper dataHemoglobinMapper;

    @Override
    public int insert(DataHemoglobin t) throws Exception {
        return super.insert(t);
    }

    @Override
    public int update(DataHemoglobin t) throws Exception {
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
        return dataHemoglobinMapper.countWhere(where);
    }

    @Override
    public  int countByTimeWhere(String start, String end, String conditions) throws  Exception{
        String where = "WHERE measureTime >= '" + start + "' and measureTime< '" + end + "' and " + conditions;
        return dataHemoglobinMapper.countWhere(where);
    }

    @Override
    public DataHemoglobin findById(Object id) throws Exception {
        return super.findById(id);
    }

    @Override
    public List<DataHemoglobin> findAll() throws Exception {
        return super.findAll();
    }

    @Override
    public List<DataHemoglobin> findByPage(int limit, int start) throws Exception {
        return super.findByPage(limit, start);
    }

    @Override
    public List<DataHemoglobin> findByUserID(Object userID) throws Exception {
        String where = "WHERE associateID = ANY(SELECT associateID FROM t_user_associate_device WHERE userID =  '" + userID + "')ORDER BY measureTime DESC";
        return super.findWhere(where);
    }

    @Override
    public DataHemoglobin findByRecentTime(Object userID) throws Exception {
        return dataHemoglobinMapper.findByRecentTime(userID);
    }

    @Override
    public List<Map<String, Object>> findIntervalCount(Object interval, Object cut) throws Exception {
        return dataHemoglobinMapper.findIntervalCount(interval, cut);
    }

    @Override
    public List<Map<String, Object>> findIntervalCountWhere(Object interval, Object cut, Object where) throws Exception {
        return dataHemoglobinMapper.findIntervalCountWhere(interval, cut, where);
    }
}

