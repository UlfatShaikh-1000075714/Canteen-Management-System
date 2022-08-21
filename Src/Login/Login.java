package project1;

public class Login 
{
	private String username;
	private String password;
	
	public Login(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	public boolean isValidateCustomer() 
	{
		String us_name=CustomerDB.validateCustomer(this.password);
		boolean isValidated = false;
        if(this.username.contentEquals(us_name)) 
        {
                isValidated = true;
        }
        return isValidated;
		
	}
	public boolean isValidateVendor()
	{
		boolean isValidated = false;
		if(this.username.contentEquals(VendorDB.validateVendor(this.password))) 
		{
            isValidated = true;
        }
		else
        {
        	System.out.println("Invalid Login Credential,Try Again!!!");
        }
        return isValidated;
		
	}
}
