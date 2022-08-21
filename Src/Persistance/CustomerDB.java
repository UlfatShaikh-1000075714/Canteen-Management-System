package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDB 
{
	
	public static void insertCsutomerDetails(int customer_id,String customer_name,String phone_no,int wallet_balance,String address,String username,String password)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("insert into customer values("+customer_id+",'"+customer_name+"','"+phone_no+"',"+wallet_balance+",'"+address+"','"+username+"','"+password+"')");
			ps.executeUpdate();  
			System.out.println("Successfully Stored the Data!!");
			conn.close(); 
		}
		catch(Exception e){ System.out.println(e);}		
	}
	public static int getCustomerCount()
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int count=0;
		try
		{
			ps=conn.prepareStatement("select count(*) from Customer");  
			ResultSet rs=ps.executeQuery(); 
			rs.next();
			count = rs.getInt(1);
			conn.close(); 
		}
		catch(Exception e){ System.out.println("Records Not Found!!!");System.exit(0);}
		return (count);
	}
	public static String validateCustomer(String password)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		String username = null;
		try 
        {
        	ps=conn.prepareStatement("SELECT username FROM Customer WHERE password=" + "\"" + password + "\"");  
        	ResultSet rs=ps.executeQuery(); 
			rs.next();
            username= rs.getString(1);
            conn.close();
        }
		catch (Exception e) 
        {
        	System.out.println("Invalid Password,Try Again!!!");
        	System.exit(0);
        }
		
		return username;	
	}
	public static int checkWalletBalance(int customer_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int walletBal = 0;
        try 
        {
        	ps=conn.prepareStatement("SELECT wallet_balance FROM Customer WHERE custmoer_id=" + "\"" + customer_id + "\"");
        	ResultSet rs = ps.executeQuery();
            rs.next();
            walletBal = rs.getInt(1);
            conn.close();

        } 
        catch (Exception e) 
        { System.out.println("Invalid Customer ID!!!");System.exit(0);}
        return walletBal;
		
	}
	public static void updateWalletBalance(int cust_id,int wall_bal)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		 try
		 {
			ps=conn.prepareStatement("UPDATE Customer SET wallet_balance=" + wall_bal + " WHERE custmoer_id=" + "\"" + cust_id + "\"");
	        ps.executeUpdate();
	        conn.close();
	     }
		 catch (Exception e) 
		 {
	            System.out.println("Invalid Customer ID!!!");
	            System.exit(0);
	     }
	}

}
