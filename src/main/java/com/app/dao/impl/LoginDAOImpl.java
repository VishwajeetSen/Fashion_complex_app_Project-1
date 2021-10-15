package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.dao.LoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Login;


public class LoginDAOImpl implements LoginDAO{

	public int validate_user(String userName , String password) throws BusinessException {
		int c=0;
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select userName,password from login";
					//where userName='?'and password='?'";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//preparedStatement.setString(1,userName);
			//preparedStatement.setString(2,password);
			
			
			//c=preparedStatement.executeUpdate();
			ResultSet resultset =preparedStatement.executeQuery();
			while(resultset.next())
			{ if (userName.equals(resultset.getString(1)) && password.equals(resultset.getString(2))) 
					{
				       c=1;
					}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			//throw new BusinessException("\n Internal error occured, please contact support");
		}
		return c;
		
	}
	public int create_user(Login login) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into login(firstName,lastName,userName,password,emailId,phoneNo) values(?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, login.getFirstName());
			preparedStatement.setString(2, login.getLastName());
			preparedStatement.setString(3, login.getUserName());
			preparedStatement.setString(4, login.getPassword());
			preparedStatement.setString(5, login.getEmailId());
			preparedStatement.setLong(6, login.getPhoneNo());
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
		
	}
	
	
	public int delete_account(String userName) throws BusinessException {
		int c=0;
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="delete from login where userName = '"+ userName +"'";
			Statement statement = connection.createStatement();
			c= statement.executeUpdate(sql);
			//PreparedStatement preparedStatement=connection.prepareStatement(sql);
	
			//preparedStatement.setString(1,userName);
			//preparedStatement.setString(2,password);
			
//			preparedStatement.executeQuery();
//			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			//throw new BusinessException("\n Internal error occured, please contact support");
		}
		return c;
		
	}
	
	public int update_password(String userName, String newPassword) throws BusinessException {
		int c=0;
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="UPDATE login SET password = '"+newPassword+"' where userName='"+userName+"'";
					
			
			Statement statement=connection.createStatement();
			
			//preparedStatement.setString(1,userName);
			//preparedStatement.setString(2,password);
			
			
			//c=preparedStatement.executeUpdate();
			c=statement.executeUpdate(sql);
			
			
		}  catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("\n Internal error occured, please contact support");
		}
		return c;
		
	}

}
