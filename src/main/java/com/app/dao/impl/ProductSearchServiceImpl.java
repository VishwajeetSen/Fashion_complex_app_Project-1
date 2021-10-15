package com.app.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductSearchService;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductSearchServiceImpl implements ProductSearchService{

	@Override
	public List<Product> getProductByName(String name) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select PId,ProductName,ProductPrice,Brand from product where ProductName='"+name+"'";
			
             Statement statement=connection.createStatement();
			
			
              ResultSet resultSet=statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Product product=new Product();
				product.setPId(resultSet.getInt("PId"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setProductPrice(resultSet.getInt("ProductPrice"));
				product.setBrand(resultSet.getString("Brand"));
			
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return productList;
		
	}

	@Override
	public List<Product> getProductByBrand(String brand) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select PId,ProductName,ProductPrice,Brand from product where Brand='"+brand+"'";
			
             Statement statement=connection.createStatement();
			
			
              ResultSet resultSet=statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Product product=new Product();
				product.setPId(resultSet.getInt("PId"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setProductPrice(resultSet.getInt("ProductPrice"));
				product.setBrand(resultSet.getString("Brand"));
			
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return productList;
	}

	@Override
	public List<Product> sortProductByPrice_l_to_h() throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select PId,ProductName,ProductPrice,Brand from product order by ProductPrice";
			
             Statement statement=connection.createStatement();
			
			
              ResultSet resultSet=statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Product product=new Product();
				product.setPId(resultSet.getInt("PId"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setProductPrice(resultSet.getInt("ProductPrice"));
				product.setBrand(resultSet.getString("Brand"));
			
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return productList;
	}

	@Override
	public List<Product> sortProductByPrice_h_to_l() throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select PId,ProductName,ProductPrice,Brand from product order by ProductPrice desc";
			
             Statement statement=connection.createStatement();
			
			
              ResultSet resultSet=statement.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Product product=new Product();
				product.setPId(resultSet.getInt("PId"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setProductPrice(resultSet.getInt("ProductPrice"));
				product.setBrand(resultSet.getString("Brand"));
			
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return productList;
	}

}
