package api.controller;

import api.annotations.Intent;
import api.controller.base.GeneralController;
import api.model.Nurse;
import api.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库表t_nurse 的Controller层实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@RestController
@Intent("数据库表t_nurse")
@RequestMapping("nurse")
public class NurseController extends GeneralController<Nurse> {

    @Autowired
    NurseService service;

    /**
     * 添加信息
     *
     * @param model
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping("add")
    public Object add(@RequestBody Nurse model) throws Exception {
        service.insert(model);
        return null;
    }

    /**
     * 更新信息
     *
     * @param model
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping("update")
    public Object update(@RequestBody Nurse model) throws Exception {
        service.update(model);
        return null;
    }

    /**
     * 根据ID获取信息
     *
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
     *
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
     * 根据ID删除 - 假删
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("remove/{ID}")
    public Object remove(@PathVariable String ID) throws Exception {
        service.remove(ID);
        return null;
    }

    /**
     * 统计全部
     *
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
     *
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
     *
     * @param pageSize
     * @param pageNo
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping("list/{pageSize}/{pageNo}")
    public Object listByPage(@PathVariable int pageSize, @PathVariable int pageNo) throws Exception {
        return service.listByPage(pageSize, pageNo);
    }

    /**
     * 根据用户经纬度按距离由近到远排序 - 此处检索范围是整表所有护工的经纬度，后续应优化检索范围
     *
     * @param Lat 用户经度
     * @param Lng 用户纬度
     * @return
     * @throws Exception
     */
    @RequestMapping("sort/by/distance/{Lat}/{Lng}")
    public Object sortByDistance(@PathVariable double Lat, @PathVariable double Lng) throws Exception {
        return service.sortByDistance(Lat, Lng);
    }

}
