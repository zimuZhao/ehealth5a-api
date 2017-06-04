package api.service.impl;

import api.dao.DataBodyMassIndexDao;
import api.model.DataBodyMassIndex;
import api.model.base.ModelBase;
import api.service.DataBodyMassIndexService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_data_body_mass_index的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataBodyMassIndexServiceImpl extends BaseServiceImpl<DataBodyMassIndex> implements DataBodyMassIndexService{

	@Autowired
	DataBodyMassIndexDao dao;
	
	@Override
	public int insert(DataBodyMassIndex model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DataBodyMassIndex model) throws Exception {
		DataBodyMassIndex old = findById(getModelID(model));
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
	public DataBodyMassIndex findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<DataBodyMassIndex> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<DataBodyMassIndex> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit, start);
	}

	@Override
	public DataBodyMassIndex findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<DataBodyMassIndex> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<DataBodyMassIndex> list = dao.findByPage(limit, start);
		
		return new Page<DataBodyMassIndex>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}

	@Override
	public List<DataBodyMassIndex> findByUserID(Object userID) throws Exception {
		return dao.findByUserID(userID);
	}
}
