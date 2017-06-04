package api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.ForHelpDao;
import api.model.ForHelp;

/**
 * 数据库表t_for_help的Dao实现
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class ForHelpDaoImpl extends BaseDaoImpl<ForHelp> implements ForHelpDao{

	@Override
	public int insert(ForHelp t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(ForHelp t) throws Exception {
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
	public ForHelp findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<ForHelp> findAll() throws Exception {
		return super.findAll();
	}

	@Override
	public List<ForHelp> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}
}

