package project1;
import java.util.*;

public class MainClass
{
	
	public static void main(String[] args)
	{
		boolean exitFlag=true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("********* CANTEEN MANAGEMENT SYSTEM ********");
			System.out.println("1.CUSTOMER LOGIN");
			System.out.println("2.VENDOR LOGIN");
			System.out.println("3.NEW USER REGISTRAION");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter Username::");
					String customerUsername=sc.next();
					System.out.println("Enter Password::");
					String customerPassword=sc.next();
					Login loginObj1=new Login(customerUsername,customerPassword);
					if(loginObj1.isValidateCustomer()==true)
					{
						System.out.println("********* WELCOME CUSTOMER ********");
						System.out.println("1.SHOW MENU");
						System.out.println("2.ORDER PLACE");
						System.out.println("3.ORDER HISTORY");
						System.out.println("4.DISPLAY WALLET BALANCE");
						System.out.println("5.CANCEL ORDER");
						System.out.println("6.LOGOUT");
						int ch1=sc.nextInt();
						switch(ch1)
						{
							case 1:
								Menu.showMenu();
							break;
							case 2:
								orderPlace();
								System.out.println("1.Would you like to order more??");
								System.out.println("2.That's enough!!");
								int i=sc.nextInt();
								if(i==1)
									orderPlace();
								else if(i==2)
									System.out.println("Your Order IS Successfully Placed !!");
								else
									System.out.println("Invalid Input!!!");
							break;
							case 3:
								orderHistory();
							break;
							case 4:
								displayWalletBalance();
							break;
							case 5:
								cancelOrder();
							break;
							case 6:
								 System.out.println("Bye!!");
				                 exitFlag = false;
							break;
							default:
								System.out.println("Invalid option!!!\nOther inputs will not consider except 1/2/3/4/5/6");
						}
					}
					else
						System.out.println("Try Again,Invalid Login Credentials!!!");
				
				break;	
				
				case 2:
					System.out.println("Enter Username::");
					String vendorUsername=sc.next();
					System.out.println("Enter Password::");
					String vendorPassword=sc.next();
					Login loginObj2=new Login(vendorUsername,vendorPassword);
					if (loginObj2.isValidateVendor()==true)
					{
						System.out.println("********* WELCOME VENDOR ********");
						System.out.println("1.SHOW MENU");
						System.out.println("2.INSERT NEW MENU");
						System.out.println("3.UPDATE MENU");
						System.out.println("4.DELETE MENU");
						System.out.println("5.DISPLAY ORDERS");
						System.out.println("6.ACCEPT/REJECT ORDERS");
						int ch3=sc.nextInt();
						switch(ch3)
						{
							case 1:
								Menu.showMenu();
							break;
							case 2:
								insertNewMenu();
							break;
							case 3:
								updateMenu();
							break;
							case 4:
								deleteMenu();
							break;
							case 5:
								displayOrders();
							break;
							case 6:
								acceptOrRejectOrders();
							break;
							default:
								System.out.println("Invalid option!!!\nOther inputs will not consider except 1/2/3/4");
						}
					}
					else
						System.out.println("Try Again,Invalid Login Credentials!!!");
				break;
				
				case 3:
					System.out.println("Registeration For \n1.Customer\n2.Vendor\nEnter 1 Or 2");
					int num=sc.nextInt();
					if (num==1)
					{
						newCustomerRegistration();
					}
					else if(num==2)
					{
						newVendorRegistration();
					}
					else
						System.out.println("Invalid Input!!!");
				break;
				default:
					System.out.println("Invalid option!!!\nOther inputs will not consider except 1/2/3");
			}
		}while(exitFlag);
	}
	public static void newCustomerRegistration()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Customer Name::");
		String cust_name=sc.next();
		System.out.println("Enter Customer Phone Number::");
		String cust_phone=sc.next();
		System.out.println("Enter Customer Address::");
		String cust_add=sc.next();
		sc.nextLine();
		System.out.println("Enter Customer Wallet balance::");
		int wall_bal=sc.nextInt();
		Customer cobj=new Customer(cust_name,cust_phone,wall_bal,cust_add);
		cobj.addCustomer();
		
	}
	public static void newVendorRegistration()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Vendor Name::");
		String cust_name=sc.next();
		System.out.println("Enter Vendor Phone Number::");
		String cust_phone=sc.next();
		System.out.println("Enter Vendor Address::");
		String cust_add=sc.next();
		sc.nextLine();
		Vendor vobj=new Vendor(cust_name,cust_phone,cust_add);
		vobj.addVendor();
	}
	public static void orderPlace()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Customer ID::");
		int cust_id=sc.nextInt();
		System.out.println("Enter Food ID::");
		int food_id=sc.nextInt();
		System.out.println("Enter quantity::");
		int quantity=sc.nextInt();
		CustomerOrderDetails obj=new CustomerOrderDetails(cust_id,food_id,quantity);
		obj.orderPlace();
	}
	public static void displayOrders()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Vendor ID::");
		int ven_id=sc.nextInt();
		VendorOrderDetails.showOrders(ven_id);	
	}
	public static void acceptOrRejectOrders()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Order Number");
		int order_no=sc.nextInt();
		System.out.println("Enter Estimated Time in Minutes");
		int est_time=sc.nextInt();
		System.out.println("Enter Order Status:\n1)Accept\n2)Reject\nEnter 1 to accept and 2 to reject an order!");
		int status=sc.nextInt();
		VendorOrderDetails orderObj=new VendorOrderDetails();
		orderObj.orderStatus(order_no, est_time, status);
		
		
	}
	public static void orderHistory()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Customer ID:");
		int cust_id=sc.nextInt();
		CustomerOrderDetails.getOrderHistory(cust_id);
	}
	public static void displayWalletBalance()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Your Customer ID:");
		int cust_id=sc.nextInt();
		CustomerOrderDetails.getWalletBalance(cust_id);
		
	}
	public static void cancelOrder()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer ID:");
		int cust_id=sc.nextInt();
		System.out.println("************You have following pending orders************");
		System.out.println("Order Number    Food ID     Quantity              Date And Time          Order VAlue      Order Status");
		OrderDB.getPendingOrders(cust_id);
		System.out.println("Which Order Would You Want to Cancel? Enter Order Number: ");
		int ord_no=sc.nextInt();
		CustomerOrderDetails.cancelOrders(ord_no);
	}
	public static void insertNewMenu()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Food Type::");
		String food_type=sc.next();
		System.out.println("Enter Calorie::");
		int calorie=sc.nextInt();
		System.out.println("Enter Amount::");
		int amount=sc.nextInt();
		System.out.println("Enter Vendor ID::");
		int vendor_id=sc.nextInt();
		System.out.println("Enter Food Name::");
		String food_name=sc.next();
		
		Menu obj=new Menu(food_type,food_name,calorie,amount,vendor_id);
		obj.addMenu(); 
	}
	public static void updateMenu()
	{
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Food ID:");
		int food_id=sc.nextInt();
		System.out.println("Enter Vendor ID:");1
		int ven_id=sc.nextInt();
		System.out.println("Enter Food Amount to be Update:");
		int amt=sc.nextInt();
		Menu.updateMenuAmount(food_id, amt,ven_id);	
	}
	public static void deleteMenu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Vendor ID:");
		int ven_id=sc.nextInt();
		System.out.println("Enter Food ID to delete Menu:");
		int f_id=sc.nextInt();
		Menu.deleteMenuRecord(f_id,ven_id);
	}
}


