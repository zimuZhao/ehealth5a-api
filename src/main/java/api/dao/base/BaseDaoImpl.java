package api.dao.base;

import api.model.base.ModelBase;
import api.util.AfReflecter;

import java.util.Date;

/**
 * 通用Dao实现基类
 * @param <T>
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
public class BaseDaoImpl<T> extends BaseDaoMybatisMYSQLImpl<T> implements BaseDao<T>{

	public BaseDaoImpl() {
		//order = "ORDER BY create_time DESC";
	}

	@Override
	public int insert(T t) throws Exception {
		ModelBase.fillNullID(t);
		AfReflecter.setMemberNoException(t, "creatTime", new Date());
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.insert(t);
	}

	@Override
	public int update(T t) throws Exception {
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.update(t);
	}

}
