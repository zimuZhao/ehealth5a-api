package api.service.impl;

import api.dao.DataWaistHipRatioDao;
import api.model.DataWaistHipRatio;
import api.model.base.ModelBase;
import api.service.DataWaistHipRatioService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_data_waist_hip_ratio的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataWaistHipRatioServiceImpl extends BaseServiceImpl<DataWaistHipRatio> implements DataWaistHipRatioService{

	@Autowired
	DataWaistHipRatioDao dao;
	
	@Override
	public int insert(DataWaistHipRatio model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DataWaistHipRatio model) throws Exception {
		DataWaistHipRatio old = findById(getModelID(model));
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
	public DataWaistHipRatio findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<DataWaistHipRatio> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<DataWaistHipRatio> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit, start);
	}

	@Override
	public DataWaistHipRatio findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<DataWaistHipRatio> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<DataWaistHipRatio> list = dao.findByPage(limit, start);
		
		return new Page<DataWaistHipRatio>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}

	@Override
	public List<DataWaistHipRatio> findByUserID(Object userID) throws Exception {
		return dao.findByUserID(userID);
	}
}
