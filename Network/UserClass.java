package Network;

public class UserClass implements User {

	private String name, email, status;

	FriendsClass fc;
	WallClass wc;
	
	public UserClass (String name, String email, String initStatus) {
		FriendsClass fc = new FriendsClass();
		WallClass wc = new WallClass();
		
		this.name = name;
		this.email = email; 
		
		status = initStatus;
	}

	public String getName() {
		return (name);
	}

	public String getEmail() {
		return (email);
	}

	public String getStatus() {
		return (status);
	}

	public void editStatus(String status) {
		this.status = status; 
	}
	
	/*
	 * Friend based commands. Calls <fc> 
	 */
	
	public void addFriend (String name) {
		fc.addFriend(name);
	}
	
	public boolean friendExists (String name) {
		return(fc.friendExists(name));
	}
}
