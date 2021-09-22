import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	Node root;
	private List<Integer> firstPath = new ArrayList<>();
	private List<Integer> secondPath = new ArrayList<>();


    public static void main(String[] args)
    {
    	LowestCommonAncestor tree = new LowestCommonAncestor();
    	
    	/*
    	 * Here's an example binary tree we can make.
    	 * 
    	 *   			      1
    	 *       			/   \
    	 *      		   2     3
    	 *     			  / \   / \
    	 *   			 4   5 6   7
    	 *
    	 */
    	
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); //this will be 2!
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6)); //this will be 1!
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4)); //this will be 1!
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4)); //this will be 2!     
    }

	/* 
	 * This function finds the path from root node to a given root of the tree.
	 * Parameters: 2 integers n1 and n2.
	 * Return: An integer representing the lowest common ancestor of the values n1 and n2.
	 */
	int findLCA(int n1, int n2) {
		clearPaths();
		return findLCAInternal(root, n1, n2);
	}

	/* 
	 * This function clears both paths (Array-Lists) for both of the nodes in question.
	 * Parameters: None.
	 * Return: None.
	 */
	void clearPaths() {
		firstPath.clear();
		secondPath.clear();
	}

	/* 
	 * This function is a private helper function for findLCA(int n1, int n2) which finds the lowest common ancestor.
	 * Parameters: The root node on the binary search tree, and 2 integers n1 and n2.
	 * Return: An integer representing the lowest common ancestor of values n1 and n2.
	 */
	private int findLCAInternal(Node root, int n1, int n2) {
		if (!findPath(root, n1, firstPath) || !findPath(root, n2, secondPath)) {
			System.out.println((firstPath.size() > 0) ? "n1 is present!" : "n1 is missing!");
			System.out.println((secondPath.size() > 0) ? "n2 is present!" : "n2 is missing!");
			return -1;
		}
		int i;
		for (i = 0; i < firstPath.size() && i < secondPath.size(); i++) {
			if (!firstPath.get(i).equals(secondPath.get(i)))
				break;
		}
		return firstPath.get(i-1);
	}

	/* 
	 * This function finds the path from root node to given root of the tree, stores the path in a vector path[].
	 * Parameters: The root node on the binary search tree, an integer value n, and the list of integers representing a path.
	 * Return: A boolean which returns true if path exists otherwise returns false.
	 */
	private boolean findPath(Node root, int n, List<Integer> path){
		//Base case
		if (root == null) {
			return false;
		}
		//Store this node. The node will be removed if not in path from root to n.
		path.add(root.data);
		if (root.data == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		//If not present in subtree rooted with root, remove root from path[] and return false
		path.remove(path.size()-1);
		return false;
	}
}
