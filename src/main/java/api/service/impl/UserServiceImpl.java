package api.service.impl;

import api.dao.*;
import api.model.*;
import api.model.base.ModelBase;
import api.service.UserService;
import api.service.base.BaseServiceImpl;
import api.util.EncryptUtils;
import api.util.Page;
import api.util.ServiceException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.jdbc.Null;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.stax.StAXResult;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数据库表t_user的Service接实现
 *
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserDao dao;
    @Autowired
    DataBloodGlucoseDao dataBloodGlucoseDao;
    @Autowired
    DataBloodOxygenDao dataBloodOxygenDao;
    @Autowired
    DataBloodPressureDao dataBloodPressureDao;
    @Autowired
    DataBodyMassIndexDao dataBodyMassIndexDao;
    @Autowired
    DataCholDao dataCholDao;
    @Autowired
    DataHemoglobinDao dataHemoglobinDao;
    @Autowired
    DataTemperatureDao dataTemperatureDao;
    @Autowired
    DataUricCidDao dataUricCidDao;
    @Autowired
    DataWaistHipRatioDao dataWaistHipRatioDao;
    @Autowired
    UserAssociateFamilyDao userAssociateFamilyDao;
    @Autowired
    UserRequestDao userRequestDao;

    @Override
    public int insert(User model) throws Exception {
        ModelBase.check(model);
        ModelBase.fillNullID(model);
        return dao.insert(model);
    }

    @Override
    public int update(User model) throws Exception {
        User old = findById(getModelID(model));
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
    public User findById(Object id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<User> findByPage(int limit, int start) throws Exception {
        return dao.findByPage(limit, start);
    }

    @Override
    public User findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public Page<User> listByPage(int pageSize, int pageNo) throws Exception {
        int limit = pageSize;
        int start = pageNo * pageSize;
        int totalRecord = dao.countAll();
        int totalPage = 1 + (totalRecord - 1) / pageSize;

        List<User> list = dao.findByPage(limit, start);

        return new Page<User>(pageNo, pageSize, totalPage, totalRecord, list) {
        };
    }

    @Override
    public int countAll() throws Exception {
        return dao.countAll();
    }

    @Override
    public User login(String username, String password) throws Exception {
        List<User> users = dao.findByUsername(username);
        if (users == null || users.size() == 0) {
            throw new ServiceException("用户不存在");
        }
        password = EncryptUtils.encryptMD5(password);

        for (User user : users) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new ServiceException("用户名或密码错误");
    }

    @Override
    public DataGroup findByRecentTime(Object userID) throws Exception {
        DataGroup dataGroup = new DataGroup();
        dataGroup.setDataBloodGlucose(dataBloodGlucoseDao.findByRecentTime(userID));
        dataGroup.setDataBloodOxygen(dataBloodOxygenDao.findByRecentTime(userID));
        dataGroup.setDataBloodPressure(dataBloodPressureDao.findByRecentTime(userID));
        dataGroup.setDataBodyMassIndex(dataBodyMassIndexDao.findByRecentTime(userID));
        dataGroup.setDataChol(dataCholDao.findByRecentTime(userID));
        dataGroup.setDataHemoglobin(dataHemoglobinDao.findByRecentTime(userID));
        dataGroup.setDataUricCid(dataUricCidDao.findByRecentTime(userID));
        dataGroup.setDataWaistHipRatio(dataWaistHipRatioDao.findByRecentTime(userID));
        dataGroup.setDataTemperature(dataTemperatureDao.findByRecentTime(userID));
        return dataGroup;
    }

    /**
     * 正态分布概率密度函数
     *
     * @param x
     * @param u         测试指标平均值 =（量程上限+量程下限）/2
     * @param standDevi 标准差
     * @return
     * @throws Exception
     */
    private double proDensity(double x, double u, double standDevi) throws Exception {
        double y2 = (x - u) * (x - u);
        double result = Math.exp(-y2 / 2 * standDevi * standDevi) * 0.398942280401432678 / standDevi;
        return result;
    }

    /**
     * 计算指标得分
     *
     * @param x
     * @param u 测试指标平均值 =（量程上限+量程下限）/2
     * @return
     * @throws Exception
     */
    private double calScores(double x, double u, double standDevi) throws Exception {
//        DecimalFormat df = new DecimalFormat("######0.00");
        return (proDensity(x, u, standDevi) / proDensity(u, u, standDevi) * 100);
    }

    @Override
    public Map<String, Object> getReport(Object userID) throws Exception {
        DataGroup dataGroup = new DataGroup();
        dataGroup.setDataBloodGlucose(dataBloodGlucoseDao.findByRecentTime(userID));
        dataGroup.setDataBloodOxygen(dataBloodOxygenDao.findByRecentTime(userID));
        dataGroup.setDataBloodPressure(dataBloodPressureDao.findByRecentTime(userID));
        dataGroup.setDataBodyMassIndex(dataBodyMassIndexDao.findByRecentTime(userID));
        dataGroup.setDataChol(dataCholDao.findByRecentTime(userID));
        dataGroup.setDataHemoglobin(dataHemoglobinDao.findByRecentTime(userID));
        dataGroup.setDataUricCid(dataUricCidDao.findByRecentTime(userID));
        dataGroup.setDataWaistHipRatio(dataWaistHipRatioDao.findByRecentTime(userID));
        dataGroup.setDataTemperature(dataTemperatureDao.findByRecentTime(userID));

        double scoreAll = 0;

        // 血压 - 收缩压 50～240 mmHg
        double scoreBloodPressureSys = 0;
        // 血压 - 舒张压 15～180 mmHg
        double scoreBloodPressureDia = 0;
        // 脉搏 - 30bpm～250bpm
        double scorePulse = 0;
        if (dataGroup.getDataBloodPressure() != null) {
            scoreBloodPressureSys = calScores(dataGroup.getDataBloodPressure().getSys(), (50 + 240) / 2, 0.05);
            scoreBloodPressureDia = calScores(dataGroup.getDataBloodPressure().getDia(), (15 + 180) / 2, 0.05);
            scorePulse = calScores(dataGroup.getDataBloodPressure().getPR(), (30 + 250) / 2, 0.01);
        }
        scoreAll += scoreBloodPressureSys + scoreBloodPressureDia + scorePulse;
        // 血氧 - 40～100%
        double scoreBloodOxygen = 0;
        if (dataGroup.getDataBloodOxygen() != null) {
            scoreBloodOxygen = calScores(dataGroup.getDataBloodOxygen().getSPO2(), (40 + 100) / 2, 0.05);
        }
        scoreAll += scoreBloodOxygen;
        // 血糖 - 1.1mmol/L～33.3mmol/L
        double scoreBloodGlucose = 0;
        if (dataGroup.getDataBloodGlucose() != null) {
            scoreBloodGlucose = calScores(dataGroup.getDataBloodGlucose().getGLU(), (1.1 + 33.3) / 2, 0.1);
        }
        scoreAll += scoreBloodGlucose;
        // 总胆固醇 - 100 - 400 毫克／100毫升 (2.59-10.35 毫莫耳／升)
        double scoreChol = 0;
        if (dataGroup.getDataChol() != null) {
            scoreChol = calScores(dataGroup.getDataChol().getCHOL(), (2.59 + 10.35) / 2, 0.1);
        }
        scoreAll += scoreChol;
        // 尿酸 - 3 - 20 毫克／100毫升 (0.18 - 1.19 毫莫耳／升)
        double scoreUricCid = 0;
        if (dataGroup.getDataUricCid() != null) {
            scoreUricCid = calScores(dataGroup.getDataUricCid().getUA(), (0.18 + 1.19) / 2, 1);
        }
        scoreAll += scoreUricCid;
        // 体温 - 32℃～42℃
        double scoreTemperature = 0;
        if (dataGroup.getDataTemperature() != null) {
            scoreTemperature = calScores(dataGroup.getDataTemperature().getTemperature(), (32 + 42) / 2, 1);
        }
        scoreAll += scoreTemperature;
        // 血红蛋白 - (7.0-26.0) g/dL
        double scoreHemoglobin = 0;
        if (dataGroup.getDataHemoglobin() != null) {
            scoreHemoglobin = calScores(dataGroup.getDataHemoglobin().getHB(), (7 + 26) / 2, 0.1);
        }
        scoreAll += scoreHemoglobin;
        Map<String, Object> score = new HashMap<>();
        score.put("scoreBloodPressureSys", scoreBloodPressureSys); //血压-收缩压
        score.put("scoreBloodPressureDia", scoreBloodPressureDia); //血压-舒张压
        score.put("scoreBloodOxygen", scoreBloodOxygen); //血氧
        score.put("scorePulse", scorePulse);//脉搏
        score.put("scoreBloodGlucose", scoreBloodGlucose); //血糖
        score.put("scoreChol", scoreChol); //总胆固醇
        score.put("scoreUricCid", scoreUricCid); //尿酸
        score.put("scoreTemperature", scoreTemperature); //体温
        score.put("scoreHemoglobin", scoreHemoglobin); //血红蛋白
        score.put("scoreAll", scoreAll / 9);
        // 以下两项未提供参考指标 暂时不做分析
//        score.put("scoreBodyMassIndex", scoreBodyMassIndex); //BMI
//        score.put("scoreWaistHipRatio", scoreWaistHipRatio);//腰臀比
        Map<String, Object> result = new HashMap<>();
        result.put("data", dataGroup);
        result.put("score", score);
        return result;

    }

    @Override
    public Map<String, Object> countByLastMonth() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String end = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, -1);
        String start = sdf.format(cal.getTime());
        int month = cal.get(Calendar.MONTH) + 1; //上个月

        List<Integer> count = new LinkedList<>();
        count.add(dataHemoglobinDao.countByTime(start, end));
        count.add(dataWaistHipRatioDao.countByTime(start, end));
        count.add(dataBodyMassIndexDao.countByTime(start, end));
        count.add(dataTemperatureDao.countByTime(start, end));
        count.add(dataBloodPressureDao.countByTime(start, end));
        count.add(dataCholDao.countByTime(start, end));
        count.add(dataUricCidDao.countByTime(start, end));
        count.add(dataBloodGlucoseDao.countByTime(start, end));
        count.add(dataBloodPressureDao.countByTime(start, end));
        count.add(dataBloodOxygenDao.countByTime(start, end));

        Integer total = 0;
        for (int k : count) {
            total += k;
        }

        List<String> name = Arrays.asList("血红蛋白", "腰臀围", "BMI", "体温", "脉搏", "总胆固醇", "尿酸", "血糖", "血压", "血氧");

        HashMap<String, Object> result = new LinkedHashMap<>();
        result.put("month", month + "月");
        result.put("total", total);
        result.put("x", count);
        result.put("y", name);
        return result;
    }


    /**
     * 填充整月数据
     * - 后台数据库回传的为有值的数据 故可能包含无数据值的天数 这里是将整个月每一天的数据值都填充（若无则置为0）
     *
     * @param day     这个月的总天数
     * @param mapList 后台回传的这个月的有值数据组
     * @return
     * @throws Exception
     */
    public List<Object> transDaily(int day, List<Map<String, Object>> mapList) throws Exception {
        // 初始化整个月每天的数据量为0
        List<Object> count = new LinkedList<>();
        for (int i = 0; i < day; i++) {
            count.add(0);
        }
        // 填充数据库统计数据
        for (int i = 0; i < mapList.size(); i++) {
            count.set(Integer.parseInt(mapList.get(i).get("measureTime").toString().substring(8, 10)) - 1, mapList.get(i).get("num"));
        }
        return count;
    }

    @Override
    public Map<String, Object> countByLastMonthDay() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        String interval = sdf.format(cal.getTime()) + "%";
        int month = cal.get(Calendar.MONTH) + 1; //上个月
        // 获取上个月的天数(日期设置为本月1号再减一天)
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        List<String> legend = Arrays.asList("血糖", "血氧", "脉搏", "血压", "BMI", "总胆固醇", "血红蛋白", "体温", "尿酸", "腰臀比");
        HashMap<String, Object> dataBGmap = new LinkedHashMap<>();
        dataBGmap.put("name", "血糖");
        dataBGmap.put("value", transDaily(day, dataBloodGlucoseDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataBOmap = new LinkedHashMap<>();
        dataBOmap.put("name", "血氧");
        List<Object> BOlist = transDaily(day, dataBloodOxygenDao.findIntervalCount(interval, 10));
        dataBOmap.put("value", BOlist);
        HashMap<String, Object> dataPRmap = new LinkedHashMap<>();
        dataPRmap.put("name", "脉搏");
        dataPRmap.put("value", BOlist);
        HashMap<String, Object> dataBPmap = new LinkedHashMap<>();
        dataBPmap.put("name", "血压");
        dataBPmap.put("value", transDaily(day, dataBloodPressureDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataBMImap = new LinkedHashMap<>();
        dataBMImap.put("name", "BMI");
        dataBMImap.put("value", transDaily(day, dataBodyMassIndexDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataCmap = new LinkedHashMap<>();
        dataCmap.put("name", "总胆固醇");
        dataCmap.put("value", transDaily(day, dataCholDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataHmap = new LinkedHashMap<>();
        dataHmap.put("name", "血红蛋白");
        dataHmap.put("value", transDaily(day, dataHemoglobinDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataTmap = new LinkedHashMap<>();
        dataTmap.put("name", "体温");
        dataTmap.put("value", transDaily(day, dataTemperatureDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataUCmap = new LinkedHashMap<>();
        dataUCmap.put("name", "尿酸");
        dataUCmap.put("value", transDaily(day, dataUricCidDao.findIntervalCount(interval, 10)));
        HashMap<String, Object> dataWHRmap = new LinkedHashMap<>();
        dataWHRmap.put("name", "腰臀比");
        dataWHRmap.put("value", transDaily(day, dataWaistHipRatioDao.findIntervalCount(interval, 10)));

        List<String> xData = new LinkedList<>(); //代表上个月每一天的天数
        for (int i = 1; i <= day; i++) {
            xData.add(i + "日");
        }
        HashMap<String, Object> result = new LinkedHashMap<>();
        result.put("legend", legend);
        result.put("x", xData);
        result.put("datas", Arrays.asList(dataBGmap, dataBOmap, dataPRmap, dataBPmap, dataBMImap, dataCmap, dataHmap, dataTmap, dataUCmap, dataWHRmap));
        return result;
    }

    @Override
    public Map<String, Object> findFamilyById(Object id) throws Exception {
        List<UserAssociateFamily> userAssociateFamilies = userAssociateFamilyDao.findFamilyById(id);
        if (userAssociateFamilies.size() == 0) {
            Map<String, Object> userList = new HashMap<>();
            userList.put("null", null);
            return userList;
        }

        List<Map<String, Object>> familiesUserList = new LinkedList<>();
        for (int i = 0; i < userAssociateFamilies.size(); i++) {
            Map<String, Object> familiesUser = new LinkedHashMap<>();
            if (id.equals(userAssociateFamilies.get(i).getUserID())) {
                String userID = userAssociateFamilies.get(i).getFamilyID();
                familiesUser.put("familiesUserID", userID);
                User user = dao.findById(userID);
                familiesUser.put("name", user.getName());
                familiesUser.put("mobile", user.getMobile());
            } else {
                String userID = userAssociateFamilies.get(i).getUserID();
                familiesUser.put("familiesUserID", userID);
                User user = dao.findById(userID);
                familiesUser.put("name", user.getName());
                familiesUser.put("mobile", user.getMobile());
            }
            familiesUserList.add(familiesUser);
        }

        Map<String, Object> familyList = new HashMap<>();
        familyList.put("userID", id);
        familyList.put("familiesUser", familiesUserList);

        return familyList;
    }

    @Override
    public String sendRequest(String senderId, String receiverId) throws Exception {
        if (senderId.equals(receiverId)) {
            throw new ServiceException("自己不用添加自己为家庭成员哦！");
        }
        User sender = findById(senderId);
        User receiver = findById(receiverId);
        if (sender == null || receiver == null) {
            throw new ServiceException("发送方/接收方用户不存在或已经被删除！");
        }
        List<UserAssociateFamily> userAssociateFamilies = userAssociateFamilyDao.findAssociation(senderId, receiverId);
        if (userAssociateFamilies.size() != 0) {
            return "家庭成员关系已存在";
        } else {
            UserRequest userRequest = new UserRequest();
            userRequest.setSenderID(senderId);
            userRequest.setReceiverID(receiverId);
            userRequest.setStatus(false);
            userRequest.setDeleteFlag(false);
            ModelBase.check(userRequest);
            ModelBase.fillNullID(userRequest);
            userRequestDao.insert(userRequest);
            return "成功发送添加请求";
        }
    }

    @Override
    public String handleRequest(String senderID, String receiverID, String requestID, Boolean state) throws Exception {
        if (state) { //state=1 允许添加为家庭成员
            if (senderID.equals(receiverID)) {
                throw new ServiceException("自己不用添加自己为家庭成员哦！");
            }
            User sender = dao.findById(senderID);
            User receiver = dao.findById(receiverID);
            if (sender == null || receiver == null) {
                throw new ServiceException("发送方/接收方用户不存在或已经被删除！");
            }
            List<UserAssociateFamily> userAssociateFamilies = userAssociateFamilyDao.findAssociation(senderID, receiverID);
            if (userAssociateFamilies.size() != 0) {
                return "家庭成员关系已存在";
            } else {
                UserAssociateFamily userAssociateFamily = new UserAssociateFamily();
                userAssociateFamily.setUserID(senderID);
                userAssociateFamily.setFamilyID(receiverID);
                ModelBase.check(userAssociateFamily);
                ModelBase.fillNullID(userAssociateFamily);
                userAssociateFamilyDao.insert(userAssociateFamily);
                UserRequest userRequest = userRequestDao.findById(requestID);
                userRequest.setStatus(true);
                userRequestDao.update(userRequest);
                return "成功添加家庭成员";
            }
        } else {
            //state = 0 拒绝添加为家庭成员 则将当前请求移出请求表
            // (此处用户体验不好 - 照现在的流程 对于发送方不知道接收方的拒绝状态 留待后续更改)
            userRequestDao.delete(requestID);
            return "请求处理成功";
        }
    }

    /**
     * 加和各项指标CountByTime
     *
     * @param start 開始時間
     * @param end   結束時間
     * @return
     * @throws Exception
     */
    private int addCountByTime(String start, String end) throws Exception {
        int total = dataHemoglobinDao.countByTime(start, end)
                + dataWaistHipRatioDao.countByTime(start, end)
                + dataBodyMassIndexDao.countByTime(start, end)
                + dataTemperatureDao.countByTime(start, end)
                + dataBloodPressureDao.countByTime(start, end)
                + dataCholDao.countByTime(start, end)
                + dataUricCidDao.countByTime(start, end)
                + dataBloodGlucoseDao.countByTime(start, end)
                + dataBloodPressureDao.countByTime(start, end)
                + dataBloodOxygenDao.countByTime(start, end);
        return total;
    }

    private List<Map.Entry<String, Integer>> CountAnomalyByTime(String start, String end) throws Exception {
        String conditions;
        int tmp;

        HashMap<String, Integer> datamap = new HashMap<>();
        conditions = "(GLU > 6.1)";
        tmp = dataBloodGlucoseDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血糖~高血糖", tmp);
        }
        conditions = "(GLU < 3.89)";
        tmp = dataBloodGlucoseDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血糖~低血糖", tmp);
        }
        conditions = "(SPO2 > 100)";
        tmp = dataBloodOxygenDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血氧~血氧异常高", tmp);
        }
        conditions = "(SPO2 < 93)";
        tmp = dataBloodOxygenDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血氧~血氧过低", tmp);
        }
        conditions = "(Sys > 140 or Dia > 90)";
        tmp = dataBloodPressureDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血压~高血压", tmp);
        }
        conditions = "( ABI < 0.9 and ABIFlag = 1 )";
        tmp = dataBloodPressureDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血压~动脉疾病风险", tmp);
        }
        conditions = "(Sys < 100 or Dia < 60)";
        tmp = dataBloodPressureDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血压~低血压", tmp);
        }
        conditions = "((height - 100) * 0.9 > (weight *1.2))";
        tmp = dataBodyMassIndexDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("BMI~过重", tmp);
        }
        conditions = "((height - 100) * 0.9 < (weight * 0.8))";
        tmp = dataBodyMassIndexDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("BMI~过轻", tmp);
        }
        conditions = "(CHOL > 6.1)";
        tmp = dataCholDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("总胆固醇~总胆固醇过高", tmp);
        }
        conditions = "(CHOL < 3.5)";
        tmp = dataCholDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("总胆固醇~总胆固醇过低", tmp);
        }
        conditions = "(HB > 160)";
        tmp = dataHemoglobinDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血红蛋白~血红蛋白异常高", tmp);
        }
        conditions = "(HB < 100)";
        tmp = dataHemoglobinDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("血红蛋白~血红蛋白异常低", tmp);
        }
        conditions = "(temperature > 38)";
        tmp = dataTemperatureDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("体温~发烧", tmp);
        }
        conditions = "(temperature < 36)";
        tmp = dataTemperatureDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("体温~低体温", tmp);
        }
        conditions = "(UA > 0.35 )";
        tmp = dataUricCidDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("体温~尿酸过高", tmp);
        }
        conditions = "(UA < 0.18)";
        tmp = dataUricCidDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("体温~尿酸过低", tmp);
        }
        conditions = "((waist / hip) > 0.9)";
        tmp = dataWaistHipRatioDao.countByTimeWhere(start, end, conditions);
        if (tmp > 0) {
            datamap.put("腰臀比~中心肥胖", tmp);
        }

        if (!datamap.isEmpty()) {
            List<Map.Entry<String, Integer>> listOfAnomaly = new ArrayList<>(datamap.entrySet());
            Collections.sort(listOfAnomaly, new Comparator<HashMap.Entry<String, Integer>>() {
                public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                    return (o2.getValue() - o1.getValue());
                }
            });
            return listOfAnomaly;
        }
        return null;
    }


    /**
     * 统计上个月异常指标趋势
     *
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> anomalyTrendByLastMonth() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        String interval = sdf.format(cal.getTime()) + "%";
        int month = cal.get(Calendar.MONTH) + 1; //上个月
        // 获取上个月的天数(日期设置为本月1号再减一天)
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String conditions;

        List<String> legend = Arrays.asList("血糖", "血氧", "脉搏", "血压", "BMI", "总胆固醇", "血红蛋白", "体温", "尿酸", "腰臀比");

        HashMap<String, Object> dataBGmap = new LinkedHashMap<>();
        conditions = "(GLU > 6.1 or GLU < 3.89)";
        dataBGmap.put("name", "血糖");
        dataBGmap.put("value", transDaily(day, dataBloodGlucoseDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataBOmap = new LinkedHashMap<>();
        conditions = "(SPO2 > 100 or SPO2 < 93 or PR > 100 or PR < 60)";
        dataBOmap.put("name", "血氧");
        List<Object> BOlist = transDaily(day, dataBloodOxygenDao.findIntervalCountWhere(interval, 10, conditions));
        dataBOmap.put("value", BOlist);
        HashMap<String, Object> dataPRmap = new LinkedHashMap<>();
        dataPRmap.put("name", "脉搏");
        dataPRmap.put("value", BOlist);
        HashMap<String, Object> dataBPmap = new LinkedHashMap<>();
        conditions = "(Sys > 140 or Dia > 90 or ( ABI < 0.9 and ABIFlag = 1 ) or PR > 100 or PR < 60)";
        dataBPmap.put("name", "血压");
        dataBPmap.put("value", transDaily(day, dataBloodPressureDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataBMImap = new LinkedHashMap<>();
        conditions = "(((height - 100) * 0.9 > (weight *1.2)) or ((height - 100) * 0.9 < (weight * 0.8)))";
        dataBMImap.put("name", "BMI");
        dataBMImap.put("value", transDaily(day, dataBodyMassIndexDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataCmap = new LinkedHashMap<>();
        conditions = "(CHOL > 6.1 or CHOL < 3.5)";
        dataCmap.put("name", "总胆固醇");
        dataCmap.put("value", transDaily(day, dataCholDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataHmap = new LinkedHashMap<>();
        conditions = "(HB > 160 or HB < 110)";
        dataHmap.put("name", "血红蛋白");
        dataHmap.put("value", transDaily(day, dataHemoglobinDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataTmap = new LinkedHashMap<>();
        conditions = "(temperature > 38 or temperature < 36)";
        dataTmap.put("name", "体温");
        dataTmap.put("value", transDaily(day, dataTemperatureDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataUCmap = new LinkedHashMap<>();
        conditions = "(UA > 0.35 or UA < 0.18)";
        dataUCmap.put("name", "尿酸");
        dataUCmap.put("value", transDaily(day, dataUricCidDao.findIntervalCountWhere(interval, 10, conditions)));
        HashMap<String, Object> dataWHRmap = new LinkedHashMap<>();
        conditions = "((waist / hip) > 0.9)";
        dataWHRmap.put("name", "腰臀比");
        dataWHRmap.put("value", transDaily(day, dataWaistHipRatioDao.findIntervalCountWhere(interval, 10, conditions)));


        List<String> xData = new LinkedList<>(); //代表上个月每一天的天数
        for (int i = 1; i <= day; i++) {
            xData.add(i + "日");
        }
        HashMap<String, Object> result = new LinkedHashMap<>();
        result.put("name", legend);
        result.put("x", xData);
        result.put("datas", Arrays.asList(dataBGmap, dataBOmap, dataPRmap, dataBPmap, dataBMImap, dataCmap, dataHmap, dataTmap, dataUCmap, dataWHRmap));
        return result;
    }

    /**
     * 罗列上个月易发疾病
     *
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> anomalyListByLastMonth() throws Exception {
        //获取上月开始时间 结束时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String end = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, -1);
        String start = sdf.format(cal.getTime());
        int month = cal.get(Calendar.MONTH) + 1; //上个月

        List<Map.Entry<String, Integer>> listOfAnomally = CountAnomalyByTime(start, end);
        List<String> index = new ArrayList<>();
        List<String> disease = new ArrayList<>();
        if (listOfAnomally == null) {
            index.add("无");
            disease.add("无");
        } else {
            for (Map.Entry<String, Integer> map : listOfAnomally) {
                String tmp = map.getKey();
                index.add(tmp.split("~")[0]);
                disease.add(tmp.split("~")[1]);
            }

        }
        HashMap<String, Object> result = new LinkedHashMap<>();
        result.put("month", month + "月");
        result.put("x", index);
        result.put("y", disease);
        return result;
    }

    /**
     * 管理员登录首页顶部四个块
     * 未完成数据
     * 月异常指标、易发疾病
     * 月覆盖区域、活跃区域、异常区域
     */
    @Override
    public Map<String, Object> adminFourPart() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String today = sdf.format(cal.getTime());

        Map<String, Object> userNum = new HashMap<>();
        userNum.put("newToday", dao.countByTime(today, today + 1));
        userNum.put("total", dao.countAll() - 1); //总数算出来会多1 再减去管理员

        //获取上月开始时间 结束时间
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 1);
        String end = sdf.format(cal2.getTime());
        cal2.add(Calendar.MONTH, -1);
        String start = sdf.format(cal2.getTime());

        List<Map.Entry<String, Integer>> listOfAnomally = CountAnomalyByTime(start, end);
        Map<String, Object> anomaly = new HashMap<>();
        if (listOfAnomally == null) {
            anomaly.put("index", "无");
            anomaly.put("disease", "无");
        } else {
            String tmp = listOfAnomally.get(0).getKey();
            anomaly.put("index", tmp.split("~")[0]);
            anomaly.put("disease", tmp.split("~")[1]);
        }
        Map<String, Object> area = new HashMap<>();
        area.put("num", "9");
        area.put("active", "龙凤区");
        area.put("abnormal", "大同区");

        Map<String, Object> upload = new HashMap<>();

        upload.put("today", addCountByTime(today, today + 1));

        // 获取上周起始日与结束日
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.add(Calendar.DATE, -1 * 7);
        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String lastWeekBegin = sdf.format(calendar1.getTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setFirstDayOfWeek(Calendar.MONDAY);
        calendar2.add(Calendar.DATE, -1 * 7);
        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String lastWeekEnd = sdf.format(calendar2.getTime());
        upload.put("lastWeek", addCountByTime(lastWeekBegin, lastWeekEnd));
        //获取上月开始时间 结束时间
        cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 1);
        end = sdf.format(cal2.getTime());
        cal2.add(Calendar.MONTH, -1);
        start = sdf.format(cal2.getTime());
        upload.put("lastMonth", addCountByTime(start, end));

        Map<String, Object> result = new HashMap<>();
        result.put("userNum", userNum);//用户数量 今日，总量
        result.put("abnormal", anomaly);//异常指标 易发疾病
        result.put("area", area);//覆盖区域 活跃区域 异常区域
        result.put("upload", upload);//数据上传 今日，上周，上月
        return result;
    }

}
