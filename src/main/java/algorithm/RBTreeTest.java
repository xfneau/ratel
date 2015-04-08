package algorithm;


public class RBTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RBTree rbTree = new RBTree();
		
		rbTree.rbInsert(new Node(41));
		rbTree.rbInsert(new Node(36));
		rbTree.rbInsert(new Node(38));
		rbTree.rbInsert(new Node(12));
		rbTree.rbInsert(new Node(19));
		rbTree.rbInsert(new Node(8));
		
		rbTree.rbDelete(19);
		
		rbTree.printTree();
	}

}
