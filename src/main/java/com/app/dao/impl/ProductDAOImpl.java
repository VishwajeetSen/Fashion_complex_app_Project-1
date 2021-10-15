package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

import com.app.model.Product;

public class ProductDAOImpl implements ProductDAO{
	
public List<Product> view_All_Product() throws BusinessException {
		
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select PId,ProductName,ProductPrice,Brand from product";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setPId(resultSet.getInt("PId"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setProductPrice(resultSet.getInt("ProductPrice"));
				product.setBrand(resultSet.getString("Brand"));
				//product.setOrderId(resultSet.getInt("OrderId"));
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return productList;
	}



@Override
public int add_product(Product product) throws BusinessException {
	int c=0;
	try(Connection connection=MySqlDbConnection.getConnection()){
		String sql="insert into product(PId,ProductName,ProductPrice,Brand) values(?,?,?,?)";
		
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, product.getPId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setInt(3, product.getProductPrice());
		preparedStatement.setString(4, product.getBrand());
	
		  
		c=preparedStatement.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println(e);//this will be replaced by logger
		//throw new BusinessException("Internal error occurred, please contact support");
	}
	return c;
}



}

