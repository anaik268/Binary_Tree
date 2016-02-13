
public class BinaryTreeMain {
	public static void main(String[] args)
	{
		BinarySearchTree bstHandle = new BinarySearchTree();
		int[] values = {15,3,20,17,18,25,12,8,7,9};
		System.out.println("Begin Entering values in tree!");
		
		for(int i : values)
			bstHandle.insertRec(bstHandle.getRoot(),i);
		
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
		
	}
	
}
