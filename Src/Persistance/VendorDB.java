package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendorDB 
{
	
	public static void insertVendorDetails(int vendor_id, String vendor_name,String phone_no,String address,String username,String password)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try
		{
			ps=conn.prepareStatement("insert into vendor values("+vendor_id+",'"+vendor_name+"','"+phone_no+"','"+address+"','"+username+"','"+password+"')");
			ps.executeUpdate();  
			System.out.println("Successfully Stored the Data!!");
			conn.close(); 
		}
		catch(Exception e){ System.out.println(e);}		
	}
	public static int getVendorCount()
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		int count=0;
		try
		{
			ps=conn.prepareStatement("select count(*) from vendor");  
			ResultSet rs=ps.executeQuery(); 
			rs.next();
            count = rs.getInt(1);
			conn.close(); 
		}
		catch(Exception e){ System.out.println("Record Not Found!!!");System.exit(0);}
		return (count);
	}

	public static String validateVendor(String password)
	{
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		String username = null;
		try 
        {
        	ps=conn.prepareStatement("SELECT username FROM Vendor WHERE password=" + "\"" + password + "\"");  
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
	

}
