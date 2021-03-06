
public class BinaryTreeMain {
	public static void main(String[] args) {
		BinarySearchTree bstHandle = new BinarySearchTree();
		BinarySearchTree bstHandle1 = new BinarySearchTree();
		int[] values = { 15, 3, 20, 17, 18, 25, 12, 8, 13, 7, 9 };
		System.out.println("Begin Entering values in tree!");

		for (int i : values)
			bstHandle.insertRec(bstHandle.getRoot(), i);

		System.out.println("Done inserting the values in tree!\n");

		System.out.println("Printing the tree in order: ");
		bstHandle.printInOrder(bstHandle.getRoot());
		System.out.println("\n");

		System.out.println("Printing the tree in pre order: ");
		bstHandle.printPreOrder(bstHandle.getRoot());
		System.out.println("\n");

		System.out.println("Printing the tree in post order: ");
		bstHandle.printPostOrder(bstHandle.getRoot());
		System.out.println("\n");
		System.out.println(bstHandle.search(bstHandle.getRoot(), 18));

		bstHandle.delete(15);
		System.out.println("Printing the tree in post order: ");
		bstHandle.printPostOrder(bstHandle.getRoot());
		System.out.println("\n");

		System.out.println("Max height of the tree is: " + bstHandle.maxHeight(bstHandle.getRoot()));
		System.out.println("Max height of the tree is: " + bstHandle.deepestNode(bstHandle.getRoot(), 0));
		int[] testArr = { 60, 39, 74, 27, 43, 71, 96, 29, 53, 73, 49 };
		System.out.println("\n\nBegin Entering values in tree 2!");

		for (int i : testArr)
			bstHandle1.insertRec(bstHandle1.getRoot(), i);

		System.out.println("Done inserting the values in tree!\n");
		System.out.println("Max height of the tree is: " + bstHandle1.maxHeight(bstHandle1.getRoot()));
		System.out.println("Max height of the tree is: " + bstHandle1.deepestNode(bstHandle1.getRoot(), 0));

		System.out.println("Is Binary Tree check: " + isBST(bstHandle1.getRoot()));
	}

	/*
	 * This function checks if the given tree is a binary search tree or not
	 */
	public static boolean isBST(Node v) {
		if (v.getLeftChild() == null && v.getRightChild() == null)
			return true;
		else if (v.getLeftChild() == null) {
			return v.getRightChild().getValue() > v.getValue() ? isBST(v.getRightChild()) : false;
		} else if (v.getRightChild() == null) {
			return v.getLeftChild().getValue() < v.getValue() ? isBST(v.getLeftChild()) : false;
		} else {
			if (v.getLeftChild().getValue() < v.getValue() && v.getRightChild().getValue() > v.getValue())
				return (isBST(v.getLeftChild()) && isBST(v.getRightChild()));
			else
				return false;
		}
	}
}
