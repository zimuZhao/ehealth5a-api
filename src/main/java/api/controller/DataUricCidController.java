package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.annotations.Intent;
import api.controller.base.GeneralController;
import api.model.DataUricCid;
import api.service.DataUricCidService;

/**
 * 数据库表t_data_uric_cid 的Controller层实现
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@RestController
@Intent("数据库表t_data_uric_cid")
@RequestMapping("datauriccid")
public class DataUricCidController extends GeneralController<DataUricCid>{

	@Autowired
	DataUricCidService service;
	
	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("add")
	public Object add(@RequestBody DataUricCid model) throws Exception {
		service.insert(model);
		return null;
	}

	/**
	 * 更新信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("update")
	public Object update(@RequestBody DataUricCid model) throws Exception {
		service.update(model);
		return null;
	}

	/**
	 * 根据ID获取信息
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("get/{ID}")
	public Object get(@PathVariable String ID) throws Exception {
		Object model = service.findById(ID);
		if (model == null) {
			return "null";
		}
		return model;
	}

	/**
	 * 根据ID删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("delete/{ID}")
	public Object delete(@PathVariable String ID) throws Exception {
		service.delete(ID);
		return null;
	}

	/**
	 * 统计全部
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("count")
	public Object count() throws Exception {
		return service.countAll();
	}

	/**
	 * 获取全部列表
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("list")
	public Object list() throws Exception {
		return service.findAll();
	}

	/**
	 * 获取分页列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("list/{pageSize}/{pageNo}")
	public Object listByPage(@PathVariable int pageSize,@PathVariable int pageNo) throws Exception {
		return service.listByPage(pageSize, pageNo);
	}

	/**
	 * 根据用户ID获取当前用户所有记录
	 *
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("find/by/{userID}")
	public Object findByUserID(@PathVariable String userID) throws Exception {
		return service.findByUserID(userID);
	}


}
