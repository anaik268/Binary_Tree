
public class BinaryTree {
	Node root;
	private int nodeCount = 0;
	
	public void insert(int value)
	{
		
		this.nodeCount++;
	}
	
	public void remove(Node v)
	{
		
		this.nodeCount--;
	}
	
	public Node getLeftChild(Node v)
	{
		return v.getLeftChild();
	}
	
	public Node getRightChild(Node v)
	{
		return v.getRightChild();
	}
	
	public boolean isExternal(Node v)
	{
		return (v.getLeftChild() == null && v.getRightChild() == null);
	}
	
	public boolean isInternal(Node v)
	{
		return (v.getLeftChild() != null || v.getRightChild() != null);
	}
	
	
	public boolean isEmpty(){
		return this.nodeCount == 0;
	}
	
	public int size(){
		return this.nodeCount;
	}
	
	public void printPreOrder(Node v)
	{
		if(v == null)
			return;
		System.out.print(v.getValue());
		printPreOrder(v.getLeftChild());
		printPreOrder(v.getRightChild());
	}
	
	public void printInOrder(Node v)
	{
		if(v == null)
			return;
		printPreOrder(v.getLeftChild());
		System.out.print(v.getValue());
		printPreOrder(v.getRightChild());
	}
	
	public void printPostOrder(Node v)
	{
		if(v == null)
			return;
		printPreOrder(v.getLeftChild());
		printPreOrder(v.getRightChild());
		System.out.print(v.getValue());
	}
	
}
