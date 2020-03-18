package Network;

public class WallClass implements Wall {

	private PostClass[] post;

	private static int DEFAULT_SIZE = 50; 
	private static int GROWTH = 2;

	private static int ZERO =  0; 

	private int counter; 

	public WallClass() {
		post = new PostClass[DEFAULT_SIZE];
		counter = ZERO;
	}
	
	public void addPost (String name, String postMsg) {
		if (isFull())
			resize();
		post[counter++] = new PostClass(name, postMsg);
	}
	
	
	
	/*
	 * Secondary and Auxiliary methods
	 */

	public boolean isFull() {
		return (counter == post.length);
	}

	private void resize() {
		PostClass[] temp = new PostClass[GROWTH * post.length];

		for (int i = ZERO; i < post.length; i++) {
			temp[i] = post[i];

		}
	}
}
