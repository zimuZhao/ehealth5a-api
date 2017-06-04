package api.service.impl;

import api.dao.DoctorDao;
import api.dao.UserAssociateDoctorDao;
import api.dao.UserDao;
import api.mapper.UserAssociateDoctorMapper;
import api.model.Doctor;
import api.model.User;
import api.model.UserAssociateDoctor;
import api.model.base.ModelBase;
import api.service.DoctorService;
import api.service.base.BaseServiceImpl;
import api.util.EncryptUtils;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据库表t_doctor的Service接实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Service
public class DoctorServiceImpl extends BaseServiceImpl<Doctor> implements DoctorService {

    @Autowired
    DoctorDao dao;
    @Autowired
    UserAssociateDoctorDao userAssociateDoctorDao;
    @Autowired
    UserDao userDao;

    @Override
    public Doctor login(String username, String password) throws Exception {
        List<Doctor> users = dao.findByUsername(username);
        if (users == null || users.size() == 0) {
            throw new ServiceException("当前医生不存在");
        }
        password = EncryptUtils.encryptMD5(password);

        for (Doctor user : users) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new ServiceException("用户名或密码错误");
    }

    @Override
    public int insert(Doctor model) throws Exception {
        ModelBase.check(model);
        ModelBase.fillNullID(model);
        model.setPassword(EncryptUtils.encryptMD5(model.getPassword()));
        return dao.insert(model);
    }

    @Override
    public int update(Doctor model) throws Exception {
        Doctor old = findById(getModelID(model));
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
    public Doctor findById(Object id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<Doctor> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public int remove(Object id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public List<Doctor> findByPage(int limit, int start) throws Exception {
        return dao.findByPageDeleteIsFalse(limit, start);
    }

    @Override
    public Doctor findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public Page<Doctor> listByPage(int pageSize, int pageNo) throws Exception {
        int limit = pageSize;
        int start = pageNo * pageSize;
        int totalRecord = dao.countDeleteIsFalse();
        int totalPage = 1 + (totalRecord - 1) / pageSize;

        List<Doctor> list = dao.findByPageDeleteIsFalse(limit, start);

        return new Page<Doctor>(pageNo, pageSize, totalPage, totalRecord, list) {
        };
    }

    @Override
    public int countAll() throws Exception {
        return dao.countAll();
    }

    @Override
    public Map<String, Object> findUserById(Object id) throws Exception {
        List<String> userID = userAssociateDoctorDao.findUserIdByDoctorId(id);
        if (userID.size() == 0) {
            Map<String, Object> userList = new HashMap<>();
            userList.put("null", null);
            return userList;
        }

        List<HashMap<String, Object>> dataList = new LinkedList<>();
        for (int i = 0; i < userID.size(); i++) {
            HashMap<String, Object> userMap = new LinkedHashMap<>();
            User user = userDao.findById(userID.get(i));
            userMap.put("userID", userID.get(i));
            userMap.put("name", user.getName());
            if (user.getSex() == 1) { //1表示男
                userMap.put("sex", "男");
            } else if (user.getSex() == 2) { //表示女
                userMap.put("sex", "女");
            } else {
                userMap.put("sex", "未知");
            }
            userMap.put("mobile", user.getMobile());
            dataList.add(userMap);
        }

        Map<String, Object> userList = new HashMap<>();
        userList.put("doctorID", id);
        userList.put("userList", dataList);

        return userList;
    }

}
