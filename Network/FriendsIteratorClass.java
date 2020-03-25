package Network;

public class FriendsIteratorClass implements FriendsIterator {
	private FriendsClass[] friend;
	
	private int counter;
	private int nextFriend;
	
	public FriendsIteratorClass(FriendsClass[] friend, int counter) {
		this.friend = friend;
		this.counter = counter;
		init();
	}
	
	public void init() {
		nextFriend = 0;
	}
	
	public boolean hasNext() {
		return ((nextFriend < counter) && (nextFriend >= 0));
	}
	
	public FriendsClass next() {
		return friend[nextFriend++];
	}
}
