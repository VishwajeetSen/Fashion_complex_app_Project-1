package com.app.login.service;

import com.app.exception.BusinessException;

public interface EmployeeValidationService {
	
	public boolean validateEmployee(String userName,String password) throws BusinessException ;
	
}
