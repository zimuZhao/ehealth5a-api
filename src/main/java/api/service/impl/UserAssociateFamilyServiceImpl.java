package api.service.impl;

import api.dao.UserAssociateFamilyDao;
import api.model.UserAssociateFamily;
import api.model.base.ModelBase;
import api.service.UserAssociateFamilyService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_user_associate_family的Service接实现
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Service
public class UserAssociateFamilyServiceImpl extends BaseServiceImpl<UserAssociateFamily> implements UserAssociateFamilyService {

	@Autowired
	UserAssociateFamilyDao dao;
	
	@Override
	public int insert(UserAssociateFamily model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(UserAssociateFamily model) throws Exception {
		UserAssociateFamily old = findById(getModelID(model));
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
	public UserAssociateFamily findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<UserAssociateFamily> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<UserAssociateFamily> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public UserAssociateFamily findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<UserAssociateFamily> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<UserAssociateFamily> list = dao.findByPage(limit, start);
		
		return new Page<UserAssociateFamily>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
