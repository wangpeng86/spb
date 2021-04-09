package com.spb.web.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sys_role")
public class Role{
	
	@Id
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@GeneratedValue(generator = "uuidGenerator")
	@Column(name = "ID", nullable = false, length = 32)
	private String id;
	@Column(name = "MENU_IDS", length = 2000)
	private String menuIds;
	@Column(name = "CODE", length = 32)
	private String code;
	@Column(name = "NAME", length = 32)
	private String name;
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
	
	public String getMenuIds() {
		return menuIds;
	}
	
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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