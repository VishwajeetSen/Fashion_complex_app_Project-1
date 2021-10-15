package com.app.login.service.impl;

import java.util.Scanner;

import com.app.exception.BusinessException;
import com.app.login.service.UserDetailsValidation;

public class UserDetailsValidationImpl implements UserDetailsValidation{
	Scanner scanner = new Scanner(System.in);
	
	public String newfirstlastnameValidation() throws BusinessException {
		String flname=scanner.next();
	    String flnpattern= "[A-Za-z]{3,30}";
		if(!flname.matches(flnpattern)) {
			System.out.println("Invalid Name....Please Try Again");
			newfirstlastnameValidation();
		}
	
		return flname;                       //valid fname and lname
		
	}
		
	public String newPasswordValidation() throws BusinessException {
		String pwd= scanner.next();
		String passwordpattern= "[a-zA-Z0-9]{5,15}";
		if(!pwd.matches(passwordpattern)) {
			System.out.println("Invalid Password ..Please try Again");
			newPasswordValidation();
		}
	
			return pwd;             // valid password
		
		
		
	}
	
	public String newEmailValidation() throws BusinessException {
		String emailId=scanner.next();
	    String emailpattern= "[a-zA-Z0-9]{3,15}@[a-z]{3,15}.com";
		if(!emailId.matches(emailpattern)) {
			System.out.println("Invalid Email....Please Try Again");
			newEmailValidation();
		}
		
		return emailId;                  // valid Email
		
	}

	
	public String newUserNameValidation() throws BusinessException {
		String username=scanner.next();
	    String usernamepattern= "[a-zA-Z(@)0-9]{4,15}";
		if(!username.matches(usernamepattern)) {
			System.out.println("Invalid UserName....Please Try Again");
			newEmailValidation();
		}
		
		return username;                 // valid User Name
		
	}
	public String newphonenoValidation() throws BusinessException {
		String phoneno=scanner.next();
	    String phonenopattern= "[0-9]{10}";
	    		
		if(!phoneno.matches(phonenopattern)) {
			System.out.println("Invalid Phone No....Please Try Again");
			newEmailValidation();
		}
		
		return phoneno;                      // valid phone No
		
	}
	
}
