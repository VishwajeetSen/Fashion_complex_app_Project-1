package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Login;

public interface LoginDAO {
	public int create_user(Login login) throws BusinessException;
	public int validate_user(String userName , String password) throws BusinessException;
	public int delete_account(String userName)throws BusinessException;
	public int update_password(String userName, String newPassword) throws BusinessException;
}

