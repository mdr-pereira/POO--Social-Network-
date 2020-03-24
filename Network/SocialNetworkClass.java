package Network;

public class SocialNetworkClass implements SocialNetwork {

	private UserClass[] user;
	

	private final static int DEFAULT_SIZE = 500; 
	private final static int GROWTH = 2; 

	private final static int ZERO = 0; 

	private int counter; 

	public SocialNetworkClass() {
		user = new UserClass [DEFAULT_SIZE];
		counter = ZERO;
	}

	/*
	 * Major void Methods
	 */

	public void register (String name, String email, String initStatus) {
		if (isFull())
			resize();

		user[counter++] = new UserClass(name, email, initStatus);	
	}
	
	
	
	/*
	 * Friend based, will call on methods which operate <FriendsClass>
	 */
	
	public boolean friendExists (String name1, String name2) {
		int i = searchIndex(name1);
		int j = searchIndex(name2);

		return(user[i].friendExists(name2) && user[j].friendExists(name1));
	} 

	public void addFriendship (String user1, String user2) {
		int i = searchIndex(user1);
		int j = searchIndex(user2);

		String email1 = user[i].getEmail();
		String email2 = user[j].getEmail();
		
		user[i].addFriend(user2, email2);
		user[j].addFriend(user1, email1);
	}
	
	public boolean hasFriends (String name) {
		int i = searchIndex(name);
		return(user[i].hasFriends());
	}

	public String getEmail(String name) {
		int i = searchIndex(name);
		return (user[i].getEmail());
	}
	
	/*
	 * Status
	 */
	public void editStatus (String name, String status) {
		int i = searchIndex(name);
		user[i].editStatus(status);
	}

	public String getStatus(String name) {
		int i = searchIndex(name);
		return (user[i].getStatus());
	}

	/*
	 * Secondary and Auxiliary methods
	 */
	public int searchIndex(String name) {
		int i = 0; 
		int result = -1; 
		boolean found = false; 

		while ((i < counter) && (!found)) {

			if (user[i].getName().equalsIgnoreCase(name)) {
				found = true; 
			} else 
				i++;
		}
		if (found) result = i; 
		return (result); 
	}

	public boolean userExists(String name) {
		boolean exists = false;
		
		if (searchIndex(name) >= 0)
			exists = true;
		
		return exists;
	}


	public boolean isEmpty() {
		return (counter == 0);
	}

	private boolean isFull() {
		return (counter == user.length);
	}

	private void resize() {
		UserClass[] temp = new UserClass[GROWTH * user.length];

		for (int i = 0; i < user.length; i++) {
			temp[i] = user[i];
		}

		user = temp; 
	}

	public UserIteratorClass iterator() {
		UserIteratorClass iterator = new UserIteratorClass(user, counter);

		return iterator;
	}
	
	public FriendsIteratorClass getIterator(String name) {
		int i = searchIndex(name);
		
		return(user[i].getIterator());
	}

}
