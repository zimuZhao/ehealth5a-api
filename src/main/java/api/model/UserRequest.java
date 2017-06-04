package api.model;

import api.annotations.dbmodel.Column;
import api.annotations.dbmodel.Id;
import api.annotations.dbmodel.Table;
import api.model.base.ModelBase;

/**
 * 数据库表t_user_request
 * @author zimu
 * @date 2017-01-01 10:23:24 中国标准时间
 */
@Table("t_user_request")
public class UserRequest extends ModelBase {

	/**
	 * 请求ID - 存储添加家庭成员的请求
	 */
	@Id
	private String requestID;
	/**
	 * 发送请求方ID
	 */
	private String senderID;
	/**
	 * 接受请求方ID
	 */
	private String receiverID;
	/**
	 * 记录创建时间
	 */
	private java.util.Date creatTime;
	/**
	 * 请求状态（0：未处理 1：已添加 2：拒绝添加）
	 */
	private Boolean status;
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

	public UserRequest() {
	}
	
	public String getRequestID(){
		return this.requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	
	public String getSenderID(){
		return this.senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	
	public String getReceiverID(){
		return this.receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	
	public java.util.Date getCreatTime(){
		return this.creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
	
	public Boolean getStatus(){
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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