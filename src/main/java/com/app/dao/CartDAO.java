package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public interface CartDAO {
	public void add_product_to_cart(String userName, String Date,String Address) throws BusinessException;
	public void previous_order(String userName) throws BusinessException;
}
