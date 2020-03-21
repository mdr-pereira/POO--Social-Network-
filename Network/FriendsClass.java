package Network;

public class FriendsClass implements Friends {
	
	private static int DEFAULT_SIZE = 50;
	private static int GROWTH = 2;
	private static int ZERO = 0;
	
	private int counter; 
	
	String[] friends;
	
	public FriendsClass() {
		friends = new String[DEFAULT_SIZE];
	}
	
	public void addFriend(String name) {
		if (!isFull())
			resize();
		
		friends[counter++] = name;
	}
	
	public String getFriend (UserClass uc) {
		return (friends[uc]);
	}
	
	public boolean friendExists (String name) {
		return (searchIndex(name) >= 0);
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

			if (friends[i].equalsIgnoreCase(name)) {
				found = true; 
			} else 
				i++;
		}
		if (found) result = i; 
		return (result); 
	}
	
	private boolean isFull() {
		return (counter == friends.length);
	}
	
	private void resize() {
		String[] temp = new String[GROWTH * friends.length];

		for (int i = ZERO; i < friends.length; i++) {
			temp[i] = friends[i];

		}
	}
}
