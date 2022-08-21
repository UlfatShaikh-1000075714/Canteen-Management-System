package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuDB 
{
	public static void inserFoodDetails(int food_id,String food_type,String food_name,int calorie,int amount,int vendor_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("insert into food values("+food_id+",'"+food_type+"','"+food_name+"',"+calorie+","+amount+","+vendor_id+")");
			int i=ps.executeUpdate();  
	    	conn.close(); 
		}
		catch(Exception e){ System.out.println(e);}		
	}
	public static void viewFoodDetails()
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{      
		    ps=conn.prepareStatement("select * from food");  
		    ResultSet rs=ps.executeQuery();  
		    while(rs.next())
		    {  
		    	
		    	System.out.println(rs.getInt(1)+"        "+rs.getString(2)+"        "+rs.getString(3)+"          "+rs.getInt(4)+"        "+rs.getInt(5));  
		    }  
		      
		    conn.close();       
		}
		catch(Exception e){ System.out.println("Records Not Found!!!");System.exit(0);}			
	}
	public static int getFoodPrice(int food_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int price = 0;
        try 
        {
        	ps=conn.prepareStatement("SELECT amount FROM food WHERE food_id=" + food_id); 
            ResultSet rs = ps.executeQuery();
            rs.next();
            price = rs.getInt(1);
            conn.close();
        } catch (Exception e) 
        {
            System.out.println("Invalid Food ID");
            System.exit(0);
        }
        return price;
	}
	public static int getVendorId(int food_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int vendor_id = 0;
        try 
        {
        	ps=conn.prepareStatement("SELECT vendor_id FROM food WHERE food_id=" + food_id); 
            ResultSet rs = ps.executeQuery();
            rs.next();
            vendor_id = rs.getInt(1);
            conn.close();
        } catch (Exception e) 
        {
            System.out.println("Invalid Food ID");
            System.exit(0);
        }
        return vendor_id;
	}
	public static void updateMenuDB(int food_id,int amt,int ven_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("update food set amount="+ "\"" + amt + "\""+"where food_id="+ "\"" + food_id + "\""+"and vendor_id="+ "\"" + ven_id + "\"");
			ps.executeUpdate();  
	    	conn.close(); 
		}
		catch(Exception e){ System.out.println("Invalid Data!!!");System.exit(0);}
	}
	public static void deleteMenuDB(int food_id,int ven_id)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("delete from food where food_id="+ "\"" + food_id + "\""+"and vendor_id="+ "\"" + ven_id + "\"");
			ps.executeUpdate();  
	    	conn.close(); 
		}
		catch(Exception e){ System.out.println("Invalid Data!!!");System.exit(0);}
	}
}
