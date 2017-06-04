package api.controller;

import api.annotations.Intent;
import api.controller.base.GeneralController;
import api.model.Doctor;
import api.model.User;
import api.service.DoctorService;
import api.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 数据库表t_doctor 的Controller层实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:48 中国标准时间
 */
@RestController
@Intent("数据库表t_doctor")
@RequestMapping("doctor")
public class DoctorController extends GeneralController<Doctor> {

    @Autowired
    DoctorService service;

    @Intent("登录")
    @RequestMapping("login")
    public Object in(String username, String password, HttpServletRequest request) throws Exception {
        Doctor doctor = service.login(username, password);
        SessionUtil.setDoctor(request, doctor);
        return doctor;
    }

    /**
     * 添加信息
     *
     * @param model
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping("add")
    public Object add(@RequestBody Doctor model) throws Exception {
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
    public Object update(@RequestBody Doctor model) throws Exception {
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
     * 根据doctorID获取userID
     *
     * @param doctorID 医生ID
     * @return null 或者 doctorID等于id的数据
     */
    @RequestMapping("get/users/{doctorID}")
    public Object getUsers(@PathVariable String doctorID) throws Exception {
        return service.findUserById(doctorID);
    }

}
