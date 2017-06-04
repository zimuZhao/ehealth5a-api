package api.service.impl;

import api.dao.DataBloodGlucoseDao;
import api.model.DataBloodGlucose;
import api.model.base.ModelBase;
import api.service.DataBloodGlucoseService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数据库表t_data_blood_glucose的Service接实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataBloodGlucoseServiceImpl extends BaseServiceImpl<DataBloodGlucose> implements DataBloodGlucoseService {

    @Autowired
    DataBloodGlucoseDao dao;

    @Override
    public int insert(DataBloodGlucose model) throws Exception {
        ModelBase.check(model);
        ModelBase.fillNullID(model);
        return dao.insert(model);
    }

    @Override
    public int update(DataBloodGlucose model) throws Exception {
        DataBloodGlucose old = findById(getModelID(model));
        if (old == null) {
            throw new ServiceException("请求更新记录不存在或已经被删除！");
        }
        model = checkNullField(old, model);
        return dao.update(model);
    }

    @Override
    public int delete(Object id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public DataBloodGlucose findById(Object id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<DataBloodGlucose> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<DataBloodGlucose> findByPage(int limit, int start) throws Exception {
        return dao.findByPage(limit, start);
    }

    @Override
    public DataBloodGlucose findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public Page<DataBloodGlucose> listByPage(int pageSize, int pageNo) throws Exception {
        int limit = pageSize;
        int start = pageNo * pageSize;
        int totalRecord = dao.countAll();
        int totalPage = 1 + (totalRecord - 1) / pageSize;

        List<DataBloodGlucose> list = dao.findByPage(limit, start);

        return new Page<DataBloodGlucose>(pageNo, pageSize, totalPage, totalRecord, list) {
        };
    }

    @Override
    public int countAll() throws Exception {
        return dao.countAll();
    }

    @Override
    public List<DataBloodGlucose> findByUserID(Object userID) throws Exception {
        return dao.findByUserID(userID);
    }

}
