package api.service.impl;

import api.dao.UserDao;
import api.dao.UserRequestDao;
import api.model.User;
import api.model.UserAssociateFamily;
import api.model.UserRequest;
import api.model.base.ModelBase;
import api.service.UserRequestService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据库表t_user_request的Service接实现
 *
 * @author zimu
 * @date 2017-01-01 10:23:24 中国标准时间
 */
@Service
public class UserRequestServiceImpl extends BaseServiceImpl<UserRequest> implements UserRequestService {

    @Autowired
    UserRequestDao dao;
    @Autowired
    UserDao userDao;

    @Override
    public int insert(UserRequest model) throws Exception {
        ModelBase.check(model);
        ModelBase.fillNullID(model);
        return dao.insert(model);
    }

    @Override
    public int update(UserRequest model) throws Exception {
        UserRequest old = findById(getModelID(model));
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
    public UserRequest findById(Object id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<UserRequest> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<UserRequest> findByPage(int limit, int start) throws Exception {
        return dao.findByPage(limit, start);
    }

    @Override
    public UserRequest findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public Page<UserRequest> listByPage(int pageSize, int pageNo) throws Exception {
        int limit = pageSize;
        int start = pageNo * pageSize;
        int totalRecord = dao.countAll();
        int totalPage = 1 + (totalRecord - 1) / pageSize;

        List<UserRequest> list = dao.findByPage(limit, start);

        return new Page<UserRequest>(pageNo, pageSize, totalPage, totalRecord, list) {
        };
    }

    @Override
    public int countAll() throws Exception {
        return dao.countAll();
    }

    @Override
    public List<UserRequest> findSendById(Object senderID) throws Exception {
        return dao.findSendById(senderID);
    }

    @Override
    public Map<String,Object> findReceiveById(Object receiverID) throws Exception {
        List<UserRequest> userRequests =  dao.findReceiveById(receiverID);
        List<String> senderName = new LinkedList<>();
        for (UserRequest userRequest : userRequests){
            senderName.add(userDao.findById(userRequest.getSenderID()).getName());
        }
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("senderName", senderName);
        result.put("userRequest", userRequests);
        return result;
    }
}
