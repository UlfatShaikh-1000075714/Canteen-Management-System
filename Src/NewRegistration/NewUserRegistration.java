package project1;

import java.util.*;

class Customer
{
	private String customer_name;
	private String phone_no;
	private int wallet_balance;
	private String address;
	
	public Customer(String cus_name,String phno,int wb,String add)
	{
		customer_name=cus_name;
		phone_no=phno;
		wallet_balance=wb;
		address=add;
	}
	public void addCustomer()
	{
		int customer_id;
		String username,password;
		int initialId = 1;
		int count=CustomerDB.getCustomerCount();
        customer_id=count+initialId;
        username=customer_name;
        password=customer_name+customer_id;
        CustomerDB.insertCsutomerDetails(customer_id, customer_name, phone_no, wallet_balance, address, username, password);  
	    System.out.println("Your Login Credentials Are::");
	    System.out.println("Your Customer ID::"+customer_id);
	    System.out.println("Your Username ::"+username);
	    System.out.println("Your Passworrd ::"+password);
	    System.out.println("Remember Your Login Credentials,Required For Login!!");
	}
	
}
class Vendor
{
	private String vendor_name;
	private String phone_no;
	private String address;

	public Vendor(String ven_name,String phno,String add)
	{
		vendor_name=ven_name;
		phone_no=phno;
		address=add;

	}
	public void addVendor()
	{
		int count,vendor_id;
		String username,password;
		try
		{
			int initialId = 1;
			count=VendorDB.getVendorCount();
            vendor_id=count+initialId;
            username =vendor_name;
            password=vendor_name+vendor_id;
            VendorDB.insertVendorDetails(vendor_id, vendor_name, phone_no, address, username, password);
	    	System.out.println("Your Login Credentials Are::");
	    	System.out.println("Your Vendor ID ::"+vendor_id);
	    	System.out.println("Your Username ::"+username);
	    	System.out.println("Your Passworrd ::"+password);
	    	System.out.println("Remember Your Login Credentials,Required For Login!!");
		}
		catch(Exception e){ System.out.println(e);}
	}
	
}