package com.app.login.service;

import com.app.exception.BusinessException;

public interface UserDetailsValidation {

	public String newfirstlastnameValidation() throws BusinessException;
	public String newUserNameValidation() throws BusinessException;
	public String newPasswordValidation() throws BusinessException;
	public String newEmailValidation() throws BusinessException ;
	public String newphonenoValidation() throws BusinessException ;
	
}
