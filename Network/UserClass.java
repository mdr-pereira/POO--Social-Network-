package Network;

public class UserClass implements User {

	private String name, email, status;

	FriendsArrayClass fac;
	
	public UserClass (String name, String email, String initStatus) {
		fac = new FriendsArrayClass();
	
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
	
	public void addFriend (String name, String email) {
		fac.addFriend(name, email);
	}
	
	public boolean friendExists (String name) {
		return(fac.friendExists(name));
	}
	
	public boolean hasFriends() {
		return (fac.hasFriends());
	}
	
	public FriendsIterator getIterator() {
		return(fac.friendsIterator());
	}
}
