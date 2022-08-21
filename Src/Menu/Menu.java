package project1;

public class Menu 
{
	private int food_id;
	private String food_type;
	private String food_name;
	private int calorie;
	private int amount;
	private int vendor_id;
	
	public Menu(String food_type, String food_name, int calorie, int amount, int vendor_id)
	{
		this.food_type=food_type;
		this.food_name=food_name;
		this.calorie=calorie;
		this.amount=amount;
		this.vendor_id=vendor_id;
	}
	public void addMenu()
	{	int initialId=1;
		int count=MenuDB.getMenuCount();
		food_id=count+initialId; 
		MenuDB.inserFoodDetails(food_id, food_type, food_name, calorie, amount, vendor_id);
		System.out.println("Successfully Stored the Data!!");  
	}
	public static void showMenu()
	{
		System.out.println("************ Today's Special Menu ************");
		System.out.println("Food ID  Food Type   Food Name       Calorie    Amount");
		MenuDB.viewFoodDetails();
	}
	public static void updateMenuAmount(int f_id,int amt,int ven_id)
	{
		MenuDB.updateMenuDB(f_id, amt,ven_id);
		System.out.println("Food is Updated!!");
	}
	public static void deleteMenuRecord(int f_id,int ven_id)
	{
		MenuDB.deleteMenuDB(f_id,ven_id);
		System.out.println("Successfully Deleted Menu!!"); 
	}
}


 
