import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	Node root;
	private List<Integer> firstPath = new ArrayList<>();
	private List<Integer> secondPath = new ArrayList<>();

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