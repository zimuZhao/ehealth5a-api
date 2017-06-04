package api.service.impl;

import api.dao.UserAuthoriseDao;
import api.model.UserAuthorise;
import api.model.base.ModelBase;
import api.service.UserAuthoriseService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_user_authorise的Service接实现
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class UserAuthoriseServiceImpl extends BaseServiceImpl<UserAuthorise> implements UserAuthoriseService{

	@Autowired
	UserAuthoriseDao dao;
	
	@Override
	public int insert(UserAuthorise model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(UserAuthorise model) throws Exception {
		UserAuthorise old = findById(getModelID(model));
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
	public UserAuthorise findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<UserAuthorise> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<UserAuthorise> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public UserAuthorise findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<UserAuthorise> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<UserAuthorise> list = dao.findByPage(limit, start);
		
		return new Page<UserAuthorise>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
