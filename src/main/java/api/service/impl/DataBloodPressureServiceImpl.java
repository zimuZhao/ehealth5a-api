package api.service.impl;

import api.dao.DataBloodPressureDao;
import api.model.DataBloodPressure;
import api.model.base.ModelBase;
import api.service.DataBloodPressureService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_data_blood_pressure的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataBloodPressureServiceImpl extends BaseServiceImpl<DataBloodPressure> implements DataBloodPressureService{

	@Autowired
	DataBloodPressureDao dao;
	
	@Override
	public int insert(DataBloodPressure model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DataBloodPressure model) throws Exception {
		DataBloodPressure old = findById(getModelID(model));
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
	public DataBloodPressure findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<DataBloodPressure> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<DataBloodPressure> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit, start);
	}

	@Override
	public DataBloodPressure findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<DataBloodPressure> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<DataBloodPressure> list = dao.findByPage(limit, start);
		
		return new Page<DataBloodPressure>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}

	@Override
	public List<DataBloodPressure> findByUserID(Object userID) throws Exception {
		return dao.findByUserID(userID);
	}
}
