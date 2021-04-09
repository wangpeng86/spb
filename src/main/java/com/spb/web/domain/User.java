package com.spb.web.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sys_user")
public class User{
	
	@Id
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@GeneratedValue(generator = "uuidGenerator")
	@Column(name = "ID")
	private String id;
	@Column(name = "ROLE_IDS", length = 2000)
	private String roleIds;
	@Column(name = "LOGIN_NAME", unique = true, nullable = false, length = 32)
	private String loginName;
	@Column(name = "PASSWORD", nullable = false, length = 32)
	private String password;
	@Column(name = "NICK_NAME", unique = true, length = 32)
	private String nickName;
	@Column(name = "REAL_NAME", length = 32)
	private String realName;
	@Column(name = "GENDER")
	private Integer gender;
	@Column(name = "PHONE", unique = true, length = 32)
	private String phone;
	@Column(name = "EMAIL", unique = true, length = 64)
	private String email;
	@Column(name="STATUS", nullable = false)
	private Integer status;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
	@Column(name = "DELETE_TIME")
	private Date deleteTime;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoleIds() {
		return roleIds;
	}
	
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
}