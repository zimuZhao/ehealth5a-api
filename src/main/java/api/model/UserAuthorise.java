package api.model;

import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_user_authorise
 * @author zimu
 * @date 2016-11-05 15:26:20 中国标准时间
 */
@Table("t_user_authorise")
public class UserAuthorise extends ModelBase{

	/**
	 * 用户授权列表时间戳记录ID
	 */
	@Id
	private String authoriseID;
	/**
	 * 设备ID
	 */
	private String deviceID;
	/**
	 * 授权时间
	 */
	private java.util.Date authoriseTime;

	public UserAuthorise() {
	}
	
	public String getAuthoriseID(){
		return this.authoriseID;
	}

	public void setAuthoriseID(String authoriseID) {
		this.authoriseID = authoriseID;
	}
	
	public String getDeviceID(){
		return this.deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	
	public java.util.Date getAuthoriseTime(){
		return this.authoriseTime;
	}

	public void setAuthoriseTime(java.util.Date authoriseTime) {
		this.authoriseTime = authoriseTime;
	}
	
}