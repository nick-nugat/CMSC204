/**
 * @author Nicholas Nguyen
 */
public class TreeNode<T> {
	private T leftChild;
	private T rightChild;
	private T data;

	/**
	 * Constructor setting left and right child to null while assigning data to data node parameter
	 * @param dataNode
	 */
	public TreeNode(T dataNode){
		leftChild = null;
		rightChild = null;
		data = dataNode;
	}

	/**
	 * Constructor for deep copy
	 * @param node
	 */
	public TreeNode(TreeNode<T> node){

	}


	public T getData() {
		return data;
	}

}