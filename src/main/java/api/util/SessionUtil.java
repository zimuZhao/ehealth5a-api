package api.util;

import api.model.Doctor;
import api.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取Session工具类
 *
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
public class SessionUtil {

    /**
     * 获取当前登陆用户
     *
     * @param request
     * @return
     */
    public static User getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user instanceof User) {
            return User.class.cast(user);
        }
        return null;
    }

    /**
     * 存入登陆用户
     *
     * @param request
     * @param user
     */
    public static void setUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
    }

    /**
     * 存入登陆醫生用户
     *
     * @param request
     * @param doctor
     */
    public static void setDoctor(HttpServletRequest request, Doctor doctor) {
        request.getSession().setAttribute("doctor", doctor);
    }

    /**
     * 获取当前登陆医生用户
     *
     * @param request
     * @return
     */
    public static Doctor getDoctor(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object doctor = session.getAttribute("doctor");
        if (doctor instanceof Doctor) {
            return Doctor.class.cast(doctor);
        }
        return null;
    }
}
