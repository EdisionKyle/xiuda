package com.miles.xiuda.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private transient String password;

	/**
	 * 员工编号
	 */
	private String userNo;

	/**
	 * 员工姓名
	 */
	private String realName;

	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 固定电话
	 */
	private String telphone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 员工职位
	 */
	private String userJob;

	/**
	 * 所属角色Id
	 */
	private String roleId;

	/**
	 * 所属角色描述
	 */
	private String roleName;

	/**
	 * 服务商Id
	 */
	private String orgId;

	/**
	 * 服务商描述
	 */
	private String orgName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建时间描述
	 */
	private String createTimeText;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 状态 0：禁用 1：正常
	 */
	private Byte status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeText() {
		return createTimeText;
	}

	public void setCreateTimeText(String createTimeText) {
		this.createTimeText = createTimeText;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + ", userNo=" + userNo + ", realName=" + realName
				+ ", mobile=" + mobile + ", telphone=" + telphone + ", email=" + email + ", userJob=" + userJob
				+ ", roleId=" + roleId + ", roleName=" + roleName + ", orgId=" + orgId + ", orgName=" + orgName
				+ ", createTime=" + createTime + ", createTimeText=" + createTimeText + ", createUser=" + createUser
				+ ", status=" + status + "]";
	}

}
