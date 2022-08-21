package project1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderDB 
{
	public static boolean insertOrderDetails(int order_no,int ven_id,int cus_id,int f_id,int quantity,String date_and_time,int order_value,String order_status)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		boolean isInserted = false;
		try
		{
			ps=conn.prepareStatement("insert into order_details(order_no,ven_id,cus_id,f_id,quantity,date_and_time,order_value,order_status) values("+order_no+","+ven_id+","+cus_id+","+f_id+","+quantity+",'"+date_and_time+"',"+order_value+",'"+order_status+"')");
			ps.executeUpdate();  
			conn.close(); 
			isInserted=true;
		}
		catch(Exception e){ System.out.println(e);}		
		return isInserted;
	}
	public static int getOrderDetailsCount()
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int count=0;
		try
		{
			ps=conn.prepareStatement("select count(*) from order_details");  
			ResultSet rs=ps.executeQuery(); 
			rs.next();
            count = rs.getInt(1);
			conn.close(); 
		}
		catch(Exception e){ System.out.println("No Records Found!!!");}
		return (count);
	}
	public static void getOrderDetails(int ven_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{      
		    ps=conn.prepareStatement("select order_no,cus_id,f_id,quantity,Date_and_time,order_value from order_details where ven_id="+ "\"" + ven_id + "\"");  
		    ResultSet rs=ps.executeQuery();  
		    while(rs.next())
		    {  
		    	
		    	System.out.println(rs.getInt(1)+"                "+rs.getInt(2)+"                        "+rs.getInt(3)+"                  "+rs.getInt(4)+"          "+rs.getDate(5)+rs.getTime(5)+"           "+rs.getInt(6));  
		    }        
		    conn.close();       
		}
		catch(Exception e){ System.out.println("Invalid Vendor ID!!!");System.exit(0);}	
	}
	public static Timestamp getDateTime(int order_no)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		Timestamp time = null;
		try
		{
			 ps=conn.prepareStatement("select date_and_time from order_details where order_no=" + "\"" + order_no + "\"");
			 ResultSet rs = ps.executeQuery();
			 rs.next();
			 time = rs.getTimestamp(1);
			 conn.close();
			 
		}
		catch (Exception e) 
        { System.out.println("Invalid Order Number!!!"); System.exit(0);}
		return time;	 
	}
	public static void ChangeOrderStatusDB(int order_no, String est_time, String status)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("update order_details set  ETA="+ "\"" + est_time + "\""+", order_status="+ "\"" + status + "\""+" where order_no="+order_no);
			ps.executeUpdate();  
			conn.close(); 
		}
		catch(Exception e){ System.out.println("Invalid Data!!!");System.exit(0);}		
	}
	public static void getOrderHistoryDB(int cust_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{      
		    ps=conn.prepareStatement("select order_no,f_id,quantity,ETA,Date_and_time,order_value,order_status from order_details where cus_id="+ "\"" + cust_id + "\"");  
		    ResultSet rs=ps.executeQuery();  
		    while(rs.next())
		    {  
		    	
		    	System.out.println(rs.getInt(1)+"               "+rs.getInt(2)+"              "+rs.getInt(3)+"                  "+rs.getDate(4)+rs.getTime(4)+"          "+rs.getDate(5)+rs.getTime(5)+"           "+rs.getInt(6)+"          "+rs.getString(7));  
		    }        
		    conn.close();       
		}
		catch(Exception e){ System.out.println("Inavlid Customer ID!!!");System.exit(0);}	
	}
	public static void getPendingOrders(int cust_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{      
		    ps=conn.prepareStatement("select order_no,f_id,quantity,Date_and_time,order_value,order_status from order_details where cus_id="+ "\"" + cust_id + "\""+"and order_status="+ "\"" + "pending" + "\"");  
		    ResultSet rs=ps.executeQuery();  
		    while(rs.next())
		    {  
		    	
		    	System.out.println(rs.getInt(1)+"               "+rs.getInt(2)+"              "+rs.getInt(3)+"                  "+rs.getDate(4)+rs.getTime(4)+"             "+rs.getInt(5)+"          "+rs.getString(6));  
		    }        
		    conn.close();       
		}
		catch(Exception e){ System.out.println("Invalid Customer ID!!!");System.exit(0);}	

	}
	public static void cancelOrderDB(int ord_no)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("delete from order_details where order_no="+ "\"" + ord_no + "\""+"and order_status="+ "\"" + "pending" + "\"");
			ps.executeUpdate();  
			conn.close(); 
		}
		catch(Exception e){ System.out.println("Invalid Order Number!!!");System.exit(0);}		
	}
}
