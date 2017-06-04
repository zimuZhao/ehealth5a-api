package api.model;

import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_user_associate_family
 * @author zimu
 * @date 2016-12-30 21:15:51 中国标准时间
 */
@Table("t_user_associate_family")
public class UserAssociateFamily extends ModelBase {

	/**
	 * 用户-家庭成员关联关系记录ID
	 */
	@Id
	private String associateID;
	/**
	 * 用户ID
	 */
	private String userID;
	/**
	 * 家庭成员ID
	 */
	private String familyID;

	public UserAssociateFamily() {
	}
	
	public String getAssociateID(){
		return this.associateID;
	}

	public void setAssociateID(String associateID) {
		this.associateID = associateID;
	}
	
	public String getUserID(){
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getFamilyID(){
		return this.familyID;
	}

	public void setFamilyID(String familyID) {
		this.familyID = familyID;
	}
	
}