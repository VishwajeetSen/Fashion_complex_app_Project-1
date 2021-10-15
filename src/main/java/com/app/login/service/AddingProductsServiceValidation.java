package com.app.login.service;

import com.app.exception.BusinessException;


public interface AddingProductsServiceValidation {
	public int adding_products_with_address(String userName) throws BusinessException;
	
}
