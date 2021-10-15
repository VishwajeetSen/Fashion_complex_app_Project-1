package com.app.dao.impl;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;



public class CartDAOImpl implements CartDAO{
	private static Logger log = Logger.getLogger(CartDAOImpl.class);
	@Override
	public void add_product_to_cart(String userName,String Date,String Address) throws BusinessException {
		int c=0;
		Scanner scanner =new Scanner(System.in);
		log.info("Enter the Product Id that u wanna buy:");
		int PId=scanner.nextInt();
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into cart(userName,PId,Date,status,Address) values('"+ userName +"','"+ PId +"','"+ Date +"','PLACED','"+ Address+"')";
			 
			Statement statement=connection.createStatement();
				  
			c=statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			//throw new BusinessException("Internal error occurred, please contact support");
		}
		if(c==1)
		{
			log.info("Product Successfully Added to your Cart");
		}
	}
	@Override
	public void previous_order(String userName) throws BusinessException {
		
			try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="SELECT orderId,c.userName,Date,status,sum(ProductPrice) as TotalPrice,Address,l.phoneNo FROM cart c JOIN PRODUCT p ON c.PId=p.PId join login l on l.userName=c.userName group by c.userName,c.Date having  c.userName='"+userName+"'";
				
				Statement statement = connection.createStatement();
				ResultSet resultSet= statement.executeQuery(sql);
				
//				PreparedStatement preparedStatement=connection.prepareStatement(sql);
//				preparedStatement.setString(1, userName);
//				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					
				        int orderId = resultSet.getInt("orderId");
					    String Date = resultSet.getString("Date");
					    String status = resultSet.getString("status");
					    int TotalPrice = resultSet.getInt("TotalPrice");
					    String Address = resultSet.getString("Address");
					    long phoneNo = resultSet.getLong("phoneNo");
					    System.out.println(orderId + "," +userName+ "," +Date+ "," +status+"," +TotalPrice+ "," +Address+ "," +phoneNo );
					}
					 
					
				}
			 catch(ClassNotFoundException | SQLException e) {
				log.error(e);
				//throw new BusinessException("Internal error occured contact sysadmin");
			}
			
		
	}

	
	}


