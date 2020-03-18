package Network;

public class IteratorClass implements Iterator {
	private UserClass[] user; 

	private int counter; 
	private int nextUser; 

	/**
	 * @param user
	 * @param counter
	 */
	public IteratorClass(UserClass[] user, int counter) {
		this.user = user; 
		this.counter = counter; 
		init();
	}

	public void init() {
		nextUser = 0;
	}
	//	Basic Iterator methods, allow for fundamental functions
	public boolean hasNext() {
		return (nextUser < counter) && (nextUser >= 0); 
	}

	public UserClass next() {
		return user[nextUser++];
	}

}
