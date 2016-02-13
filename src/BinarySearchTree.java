
public class BinarySearchTree {
	private Node root;
	// private int nodeCount = 0;

	public void insert(int value) {
		Node temp = new Node(value);
		if (root == null) {
			root = temp;
			return;
		}
		Node ptr = this.root, prev = null;

		while (ptr != null) {
			if (ptr.getValue() > value) {
				prev = ptr;
				ptr = ptr.getLeftChild();
			} else {
				prev = ptr;
				ptr = ptr.getRightChild();
			}
		}
		if (prev.getValue() > value) {
			System.out.println("left child of: " + prev.getValue() + " is: " + value);
			prev.setLeftChild(temp);
		} else {
			System.out.println("Right child of: " + prev.getValue() + " is: " + value);
			prev.setRightChild(temp);
		}
	}

	public void insertRec(Node ptr, int value) {

	}

	public Node search(Node ptr, int value) {
		if (ptr == null)
			return null;
		if (ptr.getValue() == value)
			return ptr;
		if (ptr.getValue() > value)
			return search(ptr.getLeftChild(), value);
		if (ptr.getValue() < value)
			return search(ptr.getRightChild(), value);

		return null;
	}

	public Node getRoot() {
		return this.root;
	}

	public void remove(Node v) {

	}

	public Node getLeftChild(Node v) {
		return v.getLeftChild();
	}

	public Node getRightChild(Node v) {
		return v.getRightChild();
	}

	public boolean isExternal(Node v) {
		return (v.getLeftChild() == null && v.getRightChild() == null);
	}

	public boolean isInternal(Node v) {
		return (v.getLeftChild() != null || v.getRightChild() != null);
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node v) {
		if (v == null)
			return 0;
		return size(v.getLeftChild()) + 1 + size(v.getRightChild());
	}

	public void printPreOrder(Node v) {
		if (v == null)
			return;
		System.out.print(v.getValue() + " ");
		printPreOrder(v.getLeftChild());
		printPreOrder(v.getRightChild());
	}

	public void printInOrder(Node v) {
		if (v == null)
			return;
		printInOrder(v.getLeftChild());
		System.out.print(v.getValue() + " ");
		printInOrder(v.getRightChild());
	}

	public void printPostOrder(Node v) {
		if (v == null)
			return;
		printPostOrder(v.getLeftChild());
		printPostOrder(v.getRightChild());
		System.out.print(v.getValue() + " ");
	}

}
