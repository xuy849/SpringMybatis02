package com.springmybatis02.po;

public class UserUserInfoVo {
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	public UserInfoCustom getUserInfoCustom() {
		return userInfoCustom;
	}
	public void setUserInfoCustom(UserInfoCustom userInfoCustom) {
		this.userInfoCustom = userInfoCustom;
	}
	private UserCustom userCustom;
	private UserInfoCustom userInfoCustom;
}
