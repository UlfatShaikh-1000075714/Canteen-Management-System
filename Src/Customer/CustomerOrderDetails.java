package project1;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class CustomerOrderDetails
{
	private int customer_id;
	private int food_id;
	private int quantity;
	
	public CustomerOrderDetails(int customer_id,int food_id,int quantity)
	{
		this.customer_id=customer_id;
		this.food_id=food_id;
		this.quantity=quantity;
	}
	public void orderPlace()
	{
		int order_no,count,intitial_order_no=1;
		
		count=OrderDB.getOrderDetailsCount();
		order_no=intitial_order_no+count;
		String order_status="Pending";
		boolean orderPlaced=false;
		
		LocalDateTime obj = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String curr_datetime = obj.format(format);
		
		int wallet_balance=CustomerDB.checkWalletBalance(this.customer_id);
		int food_price=MenuDB.getFoodPrice(this.food_id);
		int food_total=this.quantity*food_price;
		if(food_total<=wallet_balance)
		{
			orderPlaced=OrderDB.insertOrderDetails(order_no, MenuDB.getVendorId(this.food_id), customer_id, food_id, quantity, curr_datetime, food_total, order_status);
			System.out.println("Your Order Value is "+food_total+" Rupees Only!!");
		}
		else
		{
			System.out.println("Insufficient Wallet Balance!!!");
		}
		if(orderPlaced==true)
		{
			wallet_balance=wallet_balance-food_total;
			CustomerDB.updateWalletBalance(this.customer_id, wallet_balance);
			System.out.println("Successfully Updated Wallet Balance!!");
		}
	}
	public static void getOrderHistory(int cust_id)
	{
		System.out.println("************Your Order History************");
		System.out.println("Order Number    Food ID     Quantity              Estimated Time               Date And Time          Order VAlue      Order Status");
		OrderDB.getOrderHistoryDB(cust_id);
	}
	public static void getWalletBalance(int cust_id)
	{
		int wallet_bal=CustomerDB.checkWalletBalance(cust_id);
		System.out.println("Your Wallet Balance Is: "+wallet_bal+" Rupees");
	}
	public static void cancelOrders(int ord_no)
	{
		OrderDB.cancelOrderDB(ord_no);
		System.out.println("Your Order Is Canceled!!");	
	}
}
