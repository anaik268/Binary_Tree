
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

	// Recursive insert into binary tree
	public void insertRec(Node ptr, int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		if (ptr.getValue() > value) {
			if (ptr.getLeftChild() != null)
				insertRec(ptr.getLeftChild(), value);
			else {
				ptr.setLeftChild(new Node(value));
				System.out.println("left child of: " + ptr.getValue() + " is: " + value);
			}
		} else {
			if (ptr.getRightChild() != null)
				insertRec(ptr.getRightChild(), value);
			else {
				ptr.setRightChild(new Node(value));
				System.out.println("Right child of: " + ptr.getValue() + " is: " + value);
			}
		}
	}

	public Node delete(int value) {
		Node x = root, p = null;
		while (x != null) {
			if (x.getValue() == value)
				break;
			p = x;
			x = x.getValue() > value ? x.getLeftChild() : x.getRightChild();
		}

		// Node not found
		if (x == null) {
			throw new IllegalArgumentException();
		}

		// Handle the case where node to remove has 2 children.
		if (x.getLeftChild() != null && x.getRightChild() != null) {
			Node y = x.getLeftChild();
			p = x;
			while (y.getRightChild() != null) {
				p = y;
				y = y.getRightChild();
			}
			x.setValue(y.getValue());
			x = y;
		}

		// If root node was to be replaced, we need to return the new node which
		// we replaced
		if (p == null)
			return x.getLeftChild() != null ? x.getLeftChild() : x.getRightChild();

		// Handle the case where its leaf node of just 1 child
		Node temp = x.getLeftChild() != null ? x.getLeftChild() : x.getRightChild();
		if (p.getLeftChild() == x) {
			p.setLeftChild(temp);
		} else {
			p.setRightChild(temp);
		}

		return root;
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

	public int maxHeight(Node v) {
		if (v == null)
			return 0;
		else
			return 1 + Math.max(maxHeight(v.getLeftChild()), maxHeight(v.getRightChild()));
	}

	public NodeAndLevel deepestNode(Node v, int level) {
		if (v.getLeftChild() == null && v.getRightChild() == null)
			return new NodeAndLevel(v, level);
		else if (v.getLeftChild() == null)
			return deepestNode(v.getRightChild(), level + 1);
		else if (v.getRightChild() == null)
			return deepestNode(v.getLeftChild(), level + 1);
		else {
			level++;
			NodeAndLevel x = deepestNode(v.getLeftChild(), level);
			NodeAndLevel y = deepestNode(v.getRightChild(), level);
			if(x.level > y.level)
				return x;
			else
				return y;
		}
	}
}
