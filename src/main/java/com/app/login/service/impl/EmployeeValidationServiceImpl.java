package com.app.login.service.impl;


import java.util.Scanner;

import org.apache.log4j.Logger;


import com.app.dao.ProductDAO;
import com.app.dao.impl.ProductDAOImpl;
import com.app.exception.BusinessException;
import com.app.login.service.EmployeeValidationService;
import com.app.model.Product;

public class EmployeeValidationServiceImpl implements EmployeeValidationService{
	private static Logger log = Logger.getLogger(EmployeeValidationServiceImpl .class);
	
	public boolean validateEmployee(String userName,String password) {
		Scanner scanner=new Scanner(System.in);
		int c=0;
//		log.info("Enter your Username");
//		String userName=scanner.next();
//		log.info("Enter your admin password");
//	    String password= scanner.next();
		
//		if (!userName.equals("admin") || !password.equals("admin@123"))
//		{
//			log.info("Only Admin can access this...Sorry");
//			//validateEmployee(userName, password);
//		}
//		else
//		{
				ProductDAO productDAO= new ProductDAOImpl();
				
				
				try {
					char ch;
					do {
						Product addedproduct=null;
						log.info("Enter  Product id");
						int pid=scanner.nextInt();
						log.info("Enter Product Name");
						String productName=scanner.next();
						log.info("Enter your Product Price");
						int productPrice=scanner.nextInt();
						log.info("Enter product's brand");
					    String brand= scanner.next();
					    
					    addedproduct =new Product(pid,productName,productPrice,brand);
						 c=productDAO.add_product(addedproduct);
						log.info("Do you want to add more item,if YES press 'Y':");
					    String str =scanner.next();
					     ch=str.charAt(0);
					}while(ch=='y'|| ch=='Y');
					
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		// }
		if(c!=0) {
		return true;
		}
		else
		return false;
	}
	


}
