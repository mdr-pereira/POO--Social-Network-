package Network;

public class PostClass {

	private String user, post;
	
	public PostClass (String user, String post) {
		this.user = user;
		this.post = post;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPost() {
		return post;
	}
}
