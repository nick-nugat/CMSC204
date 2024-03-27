import java.util.ArrayList;

/**
 * @author Nicholas Nguyen
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> node;

	/**
	 * Constructor that calls buildTree()
	 */
	public MorseCodeTree(){
		buildTree();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public TreeNode<String> getRoot() {
		node.getData();
	}

	/**
	 *
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {

	}

	/**
	 *
	 * @param code the code for the new node to be added
	 * @param result
	 */
	@Override
	public void insert(String code, String result) {

	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

	}

	/**
	 *
	 * @param code the code that describes the traversals within the tree
	 * @return
	 */
	@Override
	public String fetch(String code) {
		return null;
	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		return null;
	}

	/**
	 *
	 * @param data data of node to be deleted
	 * @return
	 * @throws UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @return
	 * @throws UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 */
	@Override
	public void buildTree() {

	}

	/**
	 *
	 * @return
	 */
	@Override
	public ArrayList<String> toArrayList() {
		return null;
	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

	}
}