package Network;

public class UserClass implements User {

	private String name, email, status;

	FriendsArrayClass fc;
	WallClass wc;
	
	public UserClass (String name, String email, String initStatus) {
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
		fc.addFriend(name, email);
	}
	
	public boolean friendExists (String name) {
		return(fc.friendExists(name));
	}
	
	public boolean hasFriends() {
		return (fc.hasFriends());
	}
	
	public FriendsIteratorClass getIterator() {
		return(fc.friendsIterator());
	}
}
