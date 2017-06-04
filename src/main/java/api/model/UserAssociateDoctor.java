package api.model;

import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_user_associate_doctor
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Table("t_user_associate_doctor")
public class UserAssociateDoctor extends ModelBase {

	/**
	 * 用户-医生关联关系记录ID
	 */
	@Id
	private String associateID;
	/**
	 * 医生ID
	 */
	private String doctorID;
	/**
	 * 用户ID
	 */
	private String userID;

	public UserAssociateDoctor() {
	}
	
	public String getAssociateID(){
		return this.associateID;
	}

	public void setAssociateID(String associateID) {
		this.associateID = associateID;
	}
	
	public String getDoctorID(){
		return this.doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	public String getUserID(){
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}