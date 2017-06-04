package api.model;

import api.annotations.dbmodel.Column;
import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_doctor
 *
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Table("t_doctor")
public class Doctor extends ModelBase {

    /**
     * 医生ID
     */
    @Id
    private String doctorID;
    /**
     * 用户名（登录）
     */
    private String userName;
    /**
     * 用户密码（登录）
     */
    private String password;
    /**
     * 医生记录创建时间
     */
    private java.util.Date creatTime;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别（1:男性，2：女性，0：未知）
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 学历
     */
    private String education;
    /**
     * 主治方向（消化内科...）
     */
    private String direction;
    /**
     * 级别（主治医生，医师...）
     */
    private String rate;
    /**
     * 工作年限
     */
    private Integer workExperience;
    /**
     * 执业编号
     */
    private String license;
    /**
     * 薪资
     */
    private Integer pay;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 经度
     */
    private Double addLng;
    /**
     * 纬度
     */
    private Double addLat;
    /**
     * 身份证号
     */
    @Column("IDNumber")
    private String iDNumber;
    /**
     * 简介（技能描述等）
     */
    private String intro;
    /**
     * 医生头像
     */
    private String imgUrl;
    /**
     * 保留字节
     */
    @Column("RES")
    private String rES;
    /**
     * 保留字段
     */
    private String description;
    /**
     * 删除标记
     */
    private Boolean deleteFlag;

    public Doctor() {
    }

    public String getDoctorID() {
        return this.doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.util.Date getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(java.util.Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getWorkExperience() {
        return this.workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getPay() {
        return this.pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAddLng() {
        return this.addLng;
    }

    public void setAddLng(Double addLng) {
        this.addLng = addLng;
    }

    public Double getAddLat() {
        return this.addLat;
    }

    public void setAddLat(Double addLat) {
        this.addLat = addLat;
    }

    public String getIDNumber() {
        return this.iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRES() {
        return this.rES;
    }

    public void setRES(String rES) {
        this.rES = rES;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}