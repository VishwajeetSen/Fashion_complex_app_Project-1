package com.app.login.service.impl;

import java.util.Scanner;

import com.app.dao.LoginDAO;

import com.app.dao.impl.LoginDAOImpl;

import com.app.exception.BusinessException;
import com.app.login.service.PasswordChangeService;

public class PasswordChangeServiceImpl implements PasswordChangeService{
	Scanner scanner = new Scanner(System.in);
public boolean validatePassword(String userName) {
	
	
		System.out.println("Enter new password");
		String newPassword=scanner.nextLine();
		String pattern= "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		if(!newPassword.matches(pattern)) {
			System.out.println("Password should contain atleast one from A-Z,a-z,0-9 and one special character");
			validatePassword(userName);
		}
		else {
			LoginDAO loginDAO= new LoginDAOImpl();
			try {
				loginDAO.update_password(userName, newPassword);
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
		}

		return true;
	}




}
