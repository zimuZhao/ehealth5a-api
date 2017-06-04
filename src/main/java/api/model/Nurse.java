package api.model;

import api.annotations.dbmodel.Column;
import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_nurse
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Table("t_nurse")
public class Nurse extends ModelBase {

	/**
	 * 护工ID
	 */
	@Id
	private String nurseID;
	/**
	 * 用户名（登录）
	 */
	private String userName;
	/**
	 * 用户密码（登录）
	 */
	private String password;
	/**
	 * 护工记录创建时间
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
	 * 民族
	 */
	private String ethnic;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 籍贯
	 */
	private String birthPlace;
	/**
	 * 服务类型（营养师，保健师）
	 */
	private String serviceType;
	/**
	 * 服务区域（南岗，道里）
	 */
	private String serviceArea;
	/**
	 * 工作年限
	 */
	private Integer workExperience;
	/**
	 * 是否住家（0：不住 1：住）
	 */
	private Boolean ifStay;
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
	 * 护工头像
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

	public Nurse() {
	}
	
	public String getNurseID(){
		return this.nurseID;
	}

	public void setNurseID(String nurseID) {
		this.nurseID = nurseID;
	}
	
	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public java.util.Date getCreatTime(){
		return this.creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSex(){
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getAge(){
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEthnic(){
		return this.ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}
	
	public String getEducation(){
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getBirthPlace(){
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public String getServiceType(){
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getServiceArea(){
		return this.serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}
	
	public Integer getWorkExperience(){
		return this.workExperience;
	}

	public void setWorkExperience(Integer workExperience) {
		this.workExperience = workExperience;
	}
	
	public Boolean getIfStay(){
		return this.ifStay;
	}

	public void setIfStay(Boolean ifStay) {
		this.ifStay = ifStay;
	}
	
	public Integer getPay(){
		return this.pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}
	
	public String getMobile(){
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getAddress(){
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Double getAddLng(){
		return this.addLng;
	}

	public void setAddLng(Double addLng) {
		this.addLng = addLng;
	}
	
	public Double getAddLat(){
		return this.addLat;
	}

	public void setAddLat(Double addLat) {
		this.addLat = addLat;
	}
	
	public String getIDNumber(){
		return this.iDNumber;
	}

	public void setIDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}
	
	public String getIntro(){
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getImgUrl(){
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getRES(){
		return this.rES;
	}

	public void setRES(String rES) {
		this.rES = rES;
	}
	
	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getDeleteFlag(){
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}