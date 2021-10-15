package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductSearchService {
	public List<Product> getProductByName(String name) throws BusinessException;
	public List<Product> getProductByBrand(String brand) throws BusinessException;
	public List<Product> sortProductByPrice_l_to_h() throws BusinessException;
	public List<Product> sortProductByPrice_h_to_l() throws BusinessException;
}
