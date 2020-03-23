package Network;

public class FriendsArrayClass implements FriendsArray {
	
	private static int DEFAULT_SIZE = 50;
	private static int GROWTH = 2;
	private static int ZERO = 0;
	
	private int counter; 
	
	private FriendsClass[] friend;
	
	public FriendsArrayClass() {
		friend = new FriendsClass[DEFAULT_SIZE];
		
		counter = ZERO;
	}
	
	public void addFriend(String name, String email) {
		if (!isFull())
			resize();
		
		friend[counter++] = new FriendsClass(name, email);
	}
	
	public boolean friendExists (String name) {
			boolean exists = false;
			
			if (searchIndex(name) >= 0)
				exists = true;
			
			return exists;
		}
	
	public boolean hasFriends() {
		return (counter > 0);
	}
	
	/*
	 * Secondary and Auxiliary methods
	 */
	
	public int searchIndex(String name) {
		int i = 0; 
		int result = -1; 
		boolean found = false; 

		while ((i < counter) && (!found)) {

			if (friend[i].getName().equalsIgnoreCase(name)) {
				found = true; 
			} else 
				i++;
		}
		if (found) result = i; 
		return (result); 
	}
	
	private boolean isFull() {
		return (counter == friend.length);
	}
	
	private void resize() {
		FriendsClass[] temp = new FriendsClass[GROWTH * friend.length];

		for (int i = ZERO; i < friend.length; i++) {
			temp[i] = friend[i];

		}
	}
	
	public FriendsIteratorClass friendsIterator() {
		FriendsIteratorClass friendsIterator = new FriendsIteratorClass(friend, counter);
		
		return friendsIterator;
	}
}


