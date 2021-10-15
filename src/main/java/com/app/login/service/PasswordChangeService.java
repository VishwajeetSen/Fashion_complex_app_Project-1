package com.app.login.service;

import com.app.exception.BusinessException;

public interface PasswordChangeService {
	public boolean validatePassword(String userName) throws BusinessException;
	
}
