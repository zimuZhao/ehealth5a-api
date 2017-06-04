package api.service.impl;

import api.dao.UserAssociateDeviceDao;
import api.model.UserAssociateDevice;
import api.model.base.ModelBase;
import api.service.UserAssociateDeviceService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_user_associate_device的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class UserAssociateDeviceServiceImpl extends BaseServiceImpl<UserAssociateDevice> implements UserAssociateDeviceService{

	@Autowired
	UserAssociateDeviceDao dao;
	
	@Override
	public int insert(UserAssociateDevice model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(UserAssociateDevice model) throws Exception {
		UserAssociateDevice old = findById(getModelID(model));
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
	public UserAssociateDevice findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<UserAssociateDevice> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<UserAssociateDevice> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public UserAssociateDevice findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<UserAssociateDevice> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<UserAssociateDevice> list = dao.findByPage(limit, start);
		
		return new Page<UserAssociateDevice>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
