package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductDAO {
	public List<Product> view_All_Product() throws BusinessException;
	public int add_product(Product product) throws BusinessException;
	

}
