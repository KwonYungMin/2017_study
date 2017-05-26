package com.admin.study.login.dto;

public class LoginDto {
	private String ADMIN_ID;
	private String ADMIN_NM;
	private String TEL_NO;
	private String MOBILE_NO;
	private String EMAIL;
	
	
	public LoginDto(){
		
	}
	
	public LoginDto(String adminId, String adminName, 
			String adminTelNo, String adminMobileNo, String adminEmail){
		this.ADMIN_ID = adminId;
		this.ADMIN_NM = adminName;
		this.TEL_NO = adminTelNo;
		this.MOBILE_NO = adminMobileNo;
		this.EMAIL = adminEmail;
	}

	public String getADMIN_ID() {
		return ADMIN_ID;
	}

	public void setADMIN_ID(String aDMIN_ID) {
		ADMIN_ID = aDMIN_ID;
	}

	public String getADMIN_NM() {
		return ADMIN_NM;
	}

	public void setADMIN_NM(String aDMIN_NM) {
		ADMIN_NM = aDMIN_NM;
	}

	public String getTEL_NO() {
		return TEL_NO;
	}

	public void setTEL_NO(String tEL_NO) {
		TEL_NO = tEL_NO;
	}

	public String getMOBILE_NO() {
		return MOBILE_NO;
	}

	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
}
