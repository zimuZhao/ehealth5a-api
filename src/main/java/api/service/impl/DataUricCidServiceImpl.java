package api.service.impl;

import api.dao.DataUricCidDao;
import api.model.DataUricCid;
import api.model.base.ModelBase;
import api.service.DataUricCidService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_data_uric_cid的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class DataUricCidServiceImpl extends BaseServiceImpl<DataUricCid> implements DataUricCidService{

	@Autowired
	DataUricCidDao dao;
	
	@Override
	public int insert(DataUricCid model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DataUricCid model) throws Exception {
		DataUricCid old = findById(getModelID(model));
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
	public DataUricCid findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<DataUricCid> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<DataUricCid> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit, start);
	}

	@Override
	public DataUricCid findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<DataUricCid> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<DataUricCid> list = dao.findByPage(limit, start);
		
		return new Page<DataUricCid>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}

	@Override
	public List<DataUricCid> findByUserID(Object userID) throws Exception {
		return dao.findByUserID(userID);
	}
}
