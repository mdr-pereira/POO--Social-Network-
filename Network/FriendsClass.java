package Network;

public class FriendsClass implements Friends {
	
	private static int DEFAULT_SIZE = 50;
	
	private int counter; 
	
	String[] friends;
	
	public FriendsClass() {
		friends = new String[DEFAULT_SIZE];
	}
	
	public void addFriend(String name) {
		if (!isFull())
		friends[counter++] = name;
	}
	
	public boolean friendExists (String name) {
		return (searchIndex(name) >= 0);
	}
	
	/*
	 * Secondary and Auxiliary methods
	 */
	
	public int searchIndex(String name) {
		int i = 0; 
		int result = -1; 
		boolean found = false; 

		while ((i < counter) && (!found)) {

			if (friends[i].equalsIgnoreCase(name)) {
				found = true; 
			} else 
				i++;
		}
		if (found) result = i; 
		return (result); 
	}
	
	public boolean isFull() {
		return (counter == friends.length);
	}
}
