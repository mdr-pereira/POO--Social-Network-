package Network;

public interface Friends {

	public void addFriend (String friend);
	
	public boolean friendExists (String friend);
	
	public int searchIndex (String friend);
	
	public boolean hasFriends();
}
