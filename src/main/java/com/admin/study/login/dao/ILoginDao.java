package com.admin.study.login.dao;

import com.admin.study.login.dto.LoginDto;

public interface ILoginDao {
	public LoginDto checkUser(String userId, String userPass);
}
