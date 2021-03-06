package api.service.impl;

import api.dao.DataTemperatureDao;
import api.model.DataTemperature;
import api.model.base.ModelBase;
import api.service.DataTemperatureService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_data_temperature的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataTemperatureServiceImpl extends BaseServiceImpl<DataTemperature> implements DataTemperatureService{

	@Autowired
	DataTemperatureDao dao;
	
	@Override
	public int insert(DataTemperature model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DataTemperature model) throws Exception {
		DataTemperature old = findById(getModelID(model));
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
	public DataTemperature findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<DataTemperature> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<DataTemperature> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit, start);
	}

	@Override
	public DataTemperature findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<DataTemperature> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<DataTemperature> list = dao.findByPage(limit, start);
		
		return new Page<DataTemperature>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}

	@Override
	public List<DataTemperature> findByUserID(Object userID) throws Exception {
		return dao.findByUserID(userID);
	}
}
