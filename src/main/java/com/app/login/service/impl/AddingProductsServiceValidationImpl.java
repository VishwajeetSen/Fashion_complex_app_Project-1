package com.app.login.service.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.exception.BusinessException;
import com.app.login.service.AddingProductsServiceValidation;

public class AddingProductsServiceValidationImpl implements AddingProductsServiceValidation {
	private static Logger log = Logger.getLogger(AddingProductsServiceValidationImpl.class);
	
	@Override
	public int adding_products_with_address(String userName) throws BusinessException {
		int c=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter today's date in 'DD/MM/YYYY' format");
		String Date= scanner.next();
		
		System.out.println("Enter your Address");
		String Address=scanner.next();
		
		String pattern= "^[#.0-9a-zA-Z\\s,-]+$";
		if(!Address.matches(pattern)) {
			System.out.println("Address is not in valid format");
			adding_products_with_address(userName);
		}
		else {
			CartDAO cartDAO= new CartDAOImpl();
			try { char ch;
			do {
				 cartDAO.add_product_to_cart(userName,Date,Address);
				 log.info("Do you want to add more item,if YES press 'Y':");
				    String str =scanner.next();
				     ch=str.charAt(0);
				}while(ch=='y'|| ch=='Y');
			
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
		}

		return c;
	}
	}
	


