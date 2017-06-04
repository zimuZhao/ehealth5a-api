package api.service.impl;

import api.dao.NurseDao;
import api.model.Nurse;
import api.model.base.ModelBase;
import api.service.NurseService;
import api.service.base.BaseServiceImpl;
import api.util.Page;
import api.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据库表t_nurse的Service接实现
 *
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Service
public class NurseServiceImpl extends BaseServiceImpl<Nurse> implements NurseService {

    @Autowired
    NurseDao dao;

    @Override
    public int insert(Nurse model) throws Exception {
        ModelBase.check(model);
        ModelBase.fillNullID(model);
        return dao.insert(model);
    }

    @Override
    public int update(Nurse model) throws Exception {
        Nurse old = findById(getModelID(model));
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
    public int remove(Object id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public Nurse findById(Object id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public List<Nurse> findAll() throws Exception {
        return dao.findDeleteIsFalse();
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<Nurse> findByPage(int limit, int start) throws Exception {
        return dao.findByPageDeleteIsFalse(limit, start);
    }

    @Override
    public Nurse findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public Page<Nurse> listByPage(int pageSize, int pageNo) throws Exception {
        int limit = pageSize;
        int start = pageNo * pageSize;
        int totalRecord = dao.countDeleteIsFalse();
        int totalPage = 1 + (totalRecord - 1) / pageSize;

        List<Nurse> list = dao.findByPageDeleteIsFalse(limit, start);

        return new Page<Nurse>(pageNo, pageSize, totalPage, totalRecord, list) {
        };
    }

    @Override
    public int countAll() throws Exception {
        return dao.countAll();
    }

    private static double EARTH_RADIUS = 6378.137; //地球平均半径

    //把经纬度转为度（°）
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为KM）
     * 参数为String类型
     *
     * @param lat1Str 用户经度
     * @param lng1Str 用户纬度
     * @param lat2Str 护工经度
     * @param lng2Str 护工纬度
     * @return
     */
    public static Double getDistance(double lat1Str, double lng1Str, double lat2Str, double lng2Str) {
        double radLat1 = rad(lat1Str);
        double radLat2 = rad(lat2Str);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1Str) - rad(lng2Str);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000) / 10000;
//        String distanceStr = distance + "";
//        distanceStr = distanceStr.
//                substring(0, distanceStr.indexOf("."));
        return distance;
    }

    @Override
    public Map<String, Object> sortByDistance(double lat, double lng) throws Exception {

        List<Nurse> nurses = dao.findDeleteIsFalse(); //这里获取所有护工列表进行比对基数（后续需更改，否则比对基数过大）
        List<Double> distance = new LinkedList<>();
        for (int i = 0; i < nurses.size(); i++) {
            distance.add(getDistance(lat, lng, nurses.get(i).getAddLat(), nurses.get(i).getAddLat()));
        }

        List<Map<String, Object>> nurseList = new LinkedList<>();
        for (int k = 0; k < distance.size(); k++) {  //保证每个距离都循环完
            int j = 0;
            double temp = distance.get(0);
            for (int i = 0; i < distance.size(); i++) {  //找到每次循环的距离最小值
                if (temp > distance.get(i)) {
                    temp = distance.get(i);
                    j = i;  //定位最小数的下标
                }
            }
            //创建每项数据组
            Map<String, Object> nurse = new LinkedHashMap<>();
            nurse.put("distance", distance.get(j));
            nurse.put("nurseID", nurses.get(j).getNurseID());
            nurse.put("name", nurses.get(j).getName());
            nurse.put("sex", nurses.get(j).getSex());
            nurse.put("age", nurses.get(j).getAge());
            nurse.put("pay", nurses.get(j).getPay());
            nurse.put("serviceType", nurses.get(j).getServiceType());
            nurse.put("imgUrl", nurses.get(j).getImgUrl());
            nurseList.add(nurse);
            //移除最小项 继续寻找下一最小项
            distance.remove(j);
            nurses.remove(j);
            k--;
        }

        Map<String, Object> userLoc = new HashMap<>();
        userLoc.put("lat", lat); //经度
        userLoc.put("lng", lng); //纬度
        Map<String, Object> disSortList = new HashMap<>();
        disSortList.put("userLoc", userLoc);
        disSortList.put("nurseList", nurseList);

        return disSortList;
    }

}
