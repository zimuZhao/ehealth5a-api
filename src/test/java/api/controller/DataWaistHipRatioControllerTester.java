package api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.DataWaistHipRatio;
import api.util.JacksonUtil;

/**
 * 数据库表t_data_waist_hip_ratio 的Controller层测试类
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DataWaistHipRatioControllerTester {

	@Autowired
	DataWaistHipRatioController controller;
	
	@Test
	public void add() throws Exception{
		DataWaistHipRatio model = new DataWaistHipRatio();
		Object result = controller.add(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void update() throws Exception {
		DataWaistHipRatio model = new DataWaistHipRatio();
		Object result = controller.update(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = controller.delete("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void count() throws Exception {
		Object result = controller.count();
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void get() throws Exception {
		Object result = controller.get("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void listByPage() throws Exception {
		Object result = controller.listByPage(6, 0);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

}
