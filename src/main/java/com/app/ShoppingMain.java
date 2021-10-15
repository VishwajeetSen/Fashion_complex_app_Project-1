package com.app;
import java.util.List;
import java.util.Scanner;
import com.app.dao.*;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.LoginDAOImpl;
import com.app.dao.impl.ProductDAOImpl;
import com.app.dao.impl.ProductSearchServiceImpl;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.login.service.AddingProductsServiceValidation;
import com.app.login.service.EmployeeValidationService;
import com.app.login.service.PasswordChangeService;
import com.app.login.service.UserDetailsValidation;
import com.app.login.service.impl.AddingProductsServiceValidationImpl;
import com.app.login.service.impl.EmployeeValidationServiceImpl;
import com.app.login.service.impl.PasswordChangeServiceImpl;
import com.app.login.service.impl.UserDetailsValidationImpl;
import com.app.model.Login;
import com.app.model.Product;


public class ShoppingMain {

	private static Logger log = Logger.getLogger(ShoppingMain.class);
	
	public static void main(String[] args) {
		int ch1 ;
		int ch2;
		
		         String userName;    
		         String password;
		         String validfirstname=null;
		         String validlastname=null;
		         String validpwd=null;
		         String validEmail=null;
		         String validusername=null;
		         String validphoneno=null;
		        LoginDAO loginDAO= new LoginDAOImpl();
		        CartDAO cartDAO = new CartDAOImpl();
		        PasswordChangeService passwordChangeService= new PasswordChangeServiceImpl();
		        UserDetailsValidation userdetailsvalidation = new UserDetailsValidationImpl();
		        ProductSearchService productSearchService=new ProductSearchServiceImpl();
                Scanner scanner = new Scanner(System.in);
				log.info("Welcome to Fashion Complex V1.0");
				log.info("==========================================");

				
				
				do { ch1 = 0;
					log.info("\nPlease login to our App or else Sign Up");
					log.info("1)Sign Up");
					log.info("2)Admin Login ");
					log.info("3)Login ");
					log.info("4)Delete Account ");
					log.info("5)EXIT");
					log.info("Please enter your choice(1-5)");

					try {
						ch1 = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
					}

					switch (ch1) {
					case 1:  //Sign Up
						log.info("Enter your Firstname");
						try {
							validfirstname=userdetailsvalidation.newfirstlastnameValidation();
						} catch (BusinessException e) {
						
							e.printStackTrace();
						}
						log.info("Enter your Lastname");
						try {
							validlastname=userdetailsvalidation.newfirstlastnameValidation();
						} catch (BusinessException e) {
						
							e.printStackTrace();
						}
						log.info("Enter your Username");
						try {
							validusername=userdetailsvalidation.newUserNameValidation();
						} catch (BusinessException e) {
						
							e.printStackTrace();
						}
						log.info("Create your password");
					    try {
							validpwd=userdetailsvalidation.newPasswordValidation();
						} catch (BusinessException e) {
						
							e.printStackTrace();
						}
					    log.info("Enter your Email Id");
						 try {
								validEmail=userdetailsvalidation.newEmailValidation();
							} catch (BusinessException e) {
							
								e.printStackTrace();
							}
					    log.info("Enter your Phone No.");
					    try {
							validphoneno=userdetailsvalidation.newEmailValidation();
						} catch (BusinessException e) {
						
							e.printStackTrace();
						}
						
						Login login =new Login( validfirstname,validlastname,validusername, validpwd, validEmail,Long.parseLong(validphoneno));
						int d=0;
						try {
							d = loginDAO.create_user(login);
						} catch (BusinessException e1) {
							
							log.warn(e1.getMessage());
						}
						System.out.println(d);
						if(d==1)
						{
							log.info("Your Account Created successfully");
						}

						break;
					case 2:    // Start of Admin Login page
						log.info("Admin Login Page");   
						
				try {
					
					log.info("Enter your Admin Username :");
					  userName=scanner.next();
					log.info("Enter your Admin Password:");
					 password=scanner.next();
					 if (!userName.equals("admin") || !password.equals("admin@123"))
						{
							log.info("Invalid Username or Password");
							//validateEmployee(userName, password);
							break;
						}
						else
						{
					int c=loginDAO.validate_user(userName,password);
					//System.out.println(c);
					if(c==1)
					{
						log.info("Welcome to the App with Admin Access\n\n");
						
						do {  ch2 = 0;
							log.info("\nWhat you wish to do today?");
							
							log.info("1)Update Account Password");
							log.info("2)Previous Orders");
							log.info("3)Place Order by adding items to your cart");
							log.info("4)View items");
							log.info("5)Search Products");
							log.info("6)Add Product ");
							log.info("7)Logout");
							log.info("8)Exit");
						
							log.info("Please enter your choice(1-6)");

							try {
								ch2 = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
							}

							switch (ch2) {
							
							case 1:
								log.info("Do you want to change password");
								String str1 = scanner.next();
								char c1=str1.charAt(0);
								if(c1=='Y'|| c1=='y')
								{   
									boolean e1=passwordChangeService.validatePassword(userName);
									
									if(e1)
									{
										log.info("Account Password Successfully Changed");
									}
								}
								

								break;
							
							case 2:
								log.info("Previous Orders...Continue Shopping :-)");
								//CartDAO cartDAO = new CartDAOImpl();
								cartDAO.previous_order(userName);

								break;
							case 3:
								log.info("Added your favourite to your Cart....");

								AddingProductsServiceValidation addingProductsServiceValidation= new AddingProductsServiceValidationImpl();
								addingProductsServiceValidation.adding_products_with_address(userName);
								
								
								break;
							case 4:
								log.info("Below are the products that you can select from: \n");
								
								try {
									ProductDAO productDAO= new ProductDAOImpl();
									List<Product> productList=productDAO.view_All_Product() ;
									if(productList!=null && productList.size()>0) {
										
										for(Product product:productList) {
											log.info(product);
										}
									}
									else {
										log.info("No Products are available");
									}
								
							} catch (BusinessException e) {
								log.warn(e.getMessage());
							}
								break;   
							case 5:
								int option = 0;
								
								do {
									log.info("\n\nWelcome to Player Search Menu... Search Your Players By various Filters from below Menu option");
									log.info("1. By Product Name");		
									log.info("2. By Product Brand");
									log.info("3. Sort by price(low to high)");
									log.info("4. Sort by price(high to low)");
									log.info("5. Go back to Main Menu");
									log.info("Please enter your choice(1-5)");

									try {
										option = Integer.parseInt(scanner.nextLine());
									} catch (NumberFormatException e) {
									}
									switch (option) {
									case 1:log.info("Enter product name to get product details");

									try {
										log.info("Enter product name to search\n");
										String name=scanner.next();
										List<Product> productList=productSearchService.getProductByName(name);
										if(productList!=null && productList.size()>0) {
											
											for(Product product:productList) {
												log.info(product);
											}
										}
										else {
											log.info("No Products are available with this name");
										}
									
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
									break;
									case 2:log.info("Search product by Brand ");

									try {
										log.info("Enter product Brand to search\n");
										String brand=scanner.next();
										List<Product> productList=productSearchService.getProductByBrand(brand);
										if(productList!=null && productList.size()>0) {
											
											for(Product product:productList) {
												log.info(product);
											}
										}
										else {
											log.info("No Products are available with this brand");
										}
									
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

										break;
									case 3:log.info("Sorted product from low to high Price  ");

									try {
										List<Product> productList=productSearchService.sortProductByPrice_l_to_h();
										if(productList!=null && productList.size()>0) {
											
											for(Product product:productList) {
												log.info(product);
											}
										}
										else {
											log.info("No Products are available");
										}
									
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

										break;
									case 4:log.info("Sorted product from high to low Price  ");

									try {
										List<Product> productList=productSearchService.sortProductByPrice_h_to_l();
										if(productList!=null && productList.size()>0) {
											
											for(Product product:productList) {
												log.info(product);
											}
										}
										else {
											log.info("No Products are available ");
										}
									
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

										break;// end of search
									
									case 5:log.info("\n\nGOING BACK TO MAIN MENU......\n\n");

										break;

									default:
										log.warn(
												"Invalid Search Option... Choice should be only number between 1-5 only. Kindly Retry ");
										break;
									}
								break;
								} while (option != 5);
							
								break;
							
							case 6:
								
								EmployeeValidationService employeeValidationService= new EmployeeValidationServiceImpl();
								boolean e2=employeeValidationService.validateEmployee(userName,password);
								if(e2)
								{
									log.info("Product Added Successfully");
								}
								break;

							case 7:	
								main(null);
								break;
									
							}
						
					}while (ch2!= 8);
						
					
					} 
					else 
					{
						log.info("Invalid Username and Password... Please try again or else...\n You are not registered  ");
					    
					}
				}
				}
				catch (BusinessException e) {
						log.warn(e.getMessage());
					}
				break; // End of Admin Login page
				
					case 3:// Start of login page 
						log.info(" Login Page");   
						
						try {
							
							log.info("Enter your Username :");
							  userName=scanner.next();
							log.info("Enter your Password:");
							 password=scanner.next();
							
							int c=loginDAO.validate_user(userName,password);
							//System.out.println(c);
							if(c==1)
							{
								log.info("Welcome to the App with Access\n\n");
								
								do {  ch2 = 0;
									log.info("\nWhat you wish to do today?");
									
									log.info("1)Update Account Password");
									log.info("2)Previous Orders");
									log.info("3)Place Order by adding items to your cart");
									log.info("4)View items");
									log.info("5)Search Products");
								
									log.info("6)Logout");
									log.info("7)Exit");
								
									log.info("Please enter your choice(1-6)");

									try {
										ch2 = Integer.parseInt(scanner.nextLine());
									} catch (NumberFormatException e) {
									}

									switch (ch2) {
									
									case 1:
										log.info("Do you want to change password");
										String str1 = scanner.next();
										char c1=str1.charAt(0);
										if(c1=='Y'|| c1=='y')
										{   
											boolean e1=passwordChangeService.validatePassword(userName);
											
											if(e1)
											{
												log.info("Account Password Successfully Changed");
											}
										}
										

										break;
									
									case 2:
										log.info("Previous Orders...Continue Shopping :-)");
										//CartDAO cartDAO = new CartDAOImpl();
										cartDAO.previous_order(userName);

										break;
									case 3:
										log.info("Added your favourite to your Cart....");

										AddingProductsServiceValidation addingProductsServiceValidation= new AddingProductsServiceValidationImpl();
										addingProductsServiceValidation.adding_products_with_address(userName);
										
										
										break;
									case 4:
										log.info("Below are the products that you can select from: \n");
										
										try {
											ProductDAO productDAO= new ProductDAOImpl();
											List<Product> productList=productDAO.view_All_Product() ;
											if(productList!=null && productList.size()>0) {
												
												for(Product product:productList) {
													log.info(product);
												}
											}
											else {
												log.info("No Products are available");
											}
										
									} catch (BusinessException e) {
										log.warn(e.getMessage());
									}
										break;   
									case 5:
										int option = 0;
										
										do {
											log.info("\n\nWelcome to Player Search Menu... Search Your Players By various Filters from below Menu option");
											log.info("1. By Product Name");		
											log.info("2. By Product Brand");
											log.info("3. Sort by price(low to high)");
											log.info("4. Sort by price(high to low)");
											log.info("5. Go back to Main Menu");
											log.info("Please enter your choice(1-5)");

											try {
												option = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {
											}
											switch (option) {
											case 1:log.info("Enter product name to get product details");

											try {
												log.info("Enter product name to search\n");
												String name=scanner.next();
												List<Product> productList=productSearchService.getProductByName(name);
												if(productList!=null && productList.size()>0) {
													
													for(Product product:productList) {
														log.info(product);
													}
												}
												else {
													log.info("No Products are available with this name");
												}
											
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
											break;
											case 2:log.info("Search product by Brand ");

											try {
												log.info("Enter product Brand to search\n");
												String brand=scanner.next();
												List<Product> productList=productSearchService.getProductByBrand(brand);
												if(productList!=null && productList.size()>0) {
													
													for(Product product:productList) {
														log.info(product);
													}
												}
												else {
													log.info("No Products are available with this brand");
												}
											
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

												break;
											case 3:log.info("Sorted product from low to high Price  ");

											try {
												List<Product> productList=productSearchService.sortProductByPrice_l_to_h();
												if(productList!=null && productList.size()>0) {
													
													for(Product product:productList) {
														log.info(product);
													}
												}
												else {
													log.info("No Products are available");
												}
											
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

												break;
											case 4:log.info("Sorted product from high to low Price  ");

											try {
												List<Product> productList=productSearchService.sortProductByPrice_h_to_l();
												if(productList!=null && productList.size()>0) {
													
													for(Product product:productList) {
														log.info(product);
													}
												}
												else {
													log.info("No Products are available ");
												}
											
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

												break;// end of search
											
											case 5:log.info("\n\nGOING BACK TO MAIN MENU......\n\n");
											
												main(null);
												break;


											default:
												log.warn(
														"Invalid Search Option... Choice should be only number between 1-5 only. Kindly Retry ");
												break;
											}
										} while (option != 5);

										break;
			
								

									case 6:	
										main(null);
										break;
											
									}
								
							}while (ch2!= 7);
								
							
							} // end of if
							else 
							{
								log.info("Invalid Username and Password... Please try again or else...\n You are not registered  ");
							    
							}
						}
			
						catch (BusinessException e) {
								log.warn(e.getMessage());
							}
						break; 
		// ----------------------------------------------------------------------------------------------------------								
					case 4:
						int e=0;
						log.info("Really wanna delete : if Yes press 'Y'");
						String str = scanner.next();
						char ch=str.charAt(0);
						if(ch=='Y'|| ch=='y')
						{    log.info("Enter your Username :");
						  String deluserName=scanner.next();
							
							try {
								e = loginDAO.delete_account(deluserName);
							} catch (BusinessException e1) {
								
								e1.printStackTrace();
							}
							
							if(e==1)
							{
								log.info("Account Deleted Successfully");
							}
							if(e!=1) {
								log.info("Account doesn't exist");
							}
						}
					 break;  //end of case 4
	//---------------------------------------------------------------------------------------------------------------------					
					case 5: 
						log.info("Thank You :-)");
						break;  //end of case 5
						}
				}while (ch1!= 5);
	
				
	
	}
}
