package project1;

import java.sql.Timestamp;
import java.util.Calendar;

class VendorOrderDetails
{
	public static void showOrders(int ven_id)
	{
		System.out.println("************Today's Orders************");
		System.out.println("Order Number        Customer ID        Food ID        Quantity         Date And Time           Order VAlue");
		OrderDB.getOrderDetails(ven_id);
		
	}
	public void orderStatus(int ord_no,int exp_time,int status)
	{
		Timestamp time,est_time;
		time=OrderDB.getDateTime(ord_no);
		Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(time.getTime());
	    cal.add(Calendar.MINUTE, exp_time);
	    est_time = new Timestamp(cal.getTime().getTime());
		String est_date_time =est_time.toString();
		est_date_time=est_date_time.substring(0,est_date_time.length()-2);
		if(status==1)
		{
			OrderDB.ChangeOrderStatusDB(ord_no,est_date_time,"Accepted");
			System.out.println("Order Is Accepted!!");
		}
		else if(status==2)
		{
			OrderDB.ChangeOrderStatusDB(ord_no,est_date_time,"Rejected");
			System.out.println("Order Is Rejected!!");
		}
		else
			System.out.println("Invalid Input");
		
	}
	
}
