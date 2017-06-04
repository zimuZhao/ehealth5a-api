package api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.dao.base.BaseDaoImpl;
import api.dao.DeviceDao;
import api.model.Device;

/**
 * 数据库表t_device的Dao实现
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Repository
public class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDao{

	@Override
	public int insert(Device t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(Device t) throws Exception {
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
	public Device findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<Device> findAll() throws Exception {
		return super.findAll();
	}

	@Override
	public List<Device> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}
}

