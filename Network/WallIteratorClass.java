package Network;

public class WallIteratorClass implements WallIterator {
	private WallClass[] wall;

	private int counter;
	private int nextPost;

	public WallIteratorClass(WallClass[] wall, int counter) {
		this.wall = wall;
		this.counter = counter;
		init();
	}

	public void init() {
		nextPost = 0;
	}

	public boolean hasNext() {
		return ((nextPost < counter) && (nextPost >= 0));
	}

	public WallClass next() {
		return wall[nextPost++];
	}
}
