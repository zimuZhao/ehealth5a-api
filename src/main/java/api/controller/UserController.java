package api.controller;

import api.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.annotations.Intent;
import api.controller.base.GeneralController;
import api.model.User;
import api.service.UserService;

/**
 * 数据库表t_user 的Controller层实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@RestController
@Intent("数据库表t_user")
@RequestMapping("user")
public class UserController extends GeneralController<User> {

    @Autowired
    UserService service;

    @RequestMapping("changeUserPwd")
    @ResponseBody
    public Object changeUserPwd(String userID, String password) throws Exception {
        User user = service.findById(userID);
        user.setPassword(EncryptUtils.encryptMD5(password));
        service.update(user);
        return "修改成功";
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
    public Object add(@RequestBody User model) throws Exception {
        User user = service.findById(model.getUserID());
        if (user == null) {
            service.insert(model);
        } else { //已存在该卡号
            if (user.getName() == null) {
                service.update(model);
            } else {
                return "添加失败！当前用户已存在";
            }

        }
        return "用户添加成功";
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
    public Object update(@RequestBody User model) throws Exception {
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
     * 获取当前用户最新健康信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("find/by/recent/{userID}")
    public Object findByRecentTime(@PathVariable String userID) throws Exception {
        Object model = service.findById(userID);
        if (model == null) {
            return "null";
        }
        return service.findByRecentTime(userID);
    }

    /**
     * 获取当前用户健康报告
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("get/report/{userID}")
    public Object getReport(@PathVariable String userID) throws Exception {
        return service.getReport(userID);
    }

    /**
     * 统计上月每个指标的上传数量
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("admin/count/by/lastmonth")
    public Object countByLastMonth() throws Exception {
        return service.countByLastMonth();
    }

    /**
     * 统计上月各指标每日的上传数量
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("admin/count/by/lastmonth/day")
    public Object countByLastMonthDay() throws Exception {
        return service.countByLastMonthDay();
    }

    /**
     * 根据ID查找家庭成员
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("find/family/by/{userID}")
    public Object findFamilyById(@PathVariable String userID) throws Exception {
        return service.findFamilyById(userID);
    }

    /**
     * 发送添加家庭成员请求
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("send/request")
    public Object sendRequest(String senderID, String receiverID) throws Exception {
        return service.sendRequest(senderID, receiverID);
    }

    /**
     * 处理添加家庭成员请求
     *
     * @param senderID   发送方ID
     * @param receiverID 接收方ID
     * @param requestID  请求ID
     * @param state      处理状态 true:通过请求 false：拒绝请求
     * @return
     * @throws Exception
     */
    @RequestMapping("handle/request")
    public Object handleRequest(String senderID, String receiverID, String requestID, Boolean state) throws Exception {
        return service.handleRequest(senderID, receiverID, requestID, state);
    }

    /**
     * 罗列上个月易发疾病
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("anomaly/list")
    public Object anomalyListByLastMonth() throws Exception {
        return service.anomalyListByLastMonth();
    }

    /**
     * 统计上个月异常指标趋势
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("anomaly/trend")
    public Object anomalyTrendByLastMonth() throws Exception {
        return service.anomalyTrendByLastMonth();
    }

    /**
     * admin-index 头部四模块
     * 今日新增用户，总用户数 月异常指标，易发疾病 月覆盖区域，活跃区域，异常区域  数据上传今日，上周，上月
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("four/part")
    public Object adminFourPart() throws Exception {
        return service.adminFourPart();
    }


}
