package com.example.demo.form;

import javax.validation.constraints.NotBlank;

public class IndexForm {
	//index
	@NotBlank
	private String loginId;
	
	@NotBlank
	private String pass;
	
	//menu
	private String searchKey;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
