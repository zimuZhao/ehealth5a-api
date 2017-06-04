package api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.UserAuthoriseDao;
import api.model.UserAuthorise;

/**
 * 数据库表t_user_authorise的Dao实现
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class UserAuthoriseDaoImpl extends BaseDaoImpl<UserAuthorise> implements UserAuthoriseDao{

	@Override
	public int insert(UserAuthorise t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(UserAuthorise t) throws Exception {
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
	public UserAuthorise findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<UserAuthorise> findAll() throws Exception {
		return super.findAll();
	}

	@Override
	public List<UserAuthorise> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}
}

