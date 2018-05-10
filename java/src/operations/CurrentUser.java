package operations;

public class CurrentUser {
	
	private static CurrentUser currUser;
	private String email;
	private String [] info;
	private CurrentUser() {
		currUser = null;
		email = null;
		info = null;
	}
	
	public static CurrentUser getInstance() {
		if(currUser == null)
			currUser = new CurrentUser();
		return currUser;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	
	public String[] getInfo() {
		IUserOperations operations = new UserOperations();
		return operations.getUserInfo(this.email);
	}
}
