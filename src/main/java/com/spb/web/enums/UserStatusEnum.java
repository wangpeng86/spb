package com.spb.web.enums;

public enum UserStatusEnum{
	
	NEW(1, "新建"),
	NORMAL(2, "正常"),
	DISABLED(9, "禁用");

	private Integer code;
	private String name;
	
	private UserStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static UserStatusEnum getUserStatusEnum(Integer code) {
		for(UserStatusEnum userStatusEnum : UserStatusEnum.values()) {
			if(userStatusEnum.code.equals(code)) return userStatusEnum;
		}
		return null;
	}
	
}