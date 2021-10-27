public class LowestCommonAncestor {
	public static Node finalLCA = null;

	public static int recurseTree(Node currentNode, Node n1, Node n2) {
		int totalMatches=0;
		// If we have reached the end of a branch, then we simply return false.
		if (currentNode == null) {
			return 0;
		}
		// If the child node is not null, we can continue.
		if(currentNode.child!=null) {
			//Iterate through the child nodes, getting the totalMatches.
			for(int i=0; i<currentNode.child.length; i++) {
				totalMatches = totalMatches + recurseTree(currentNode.child[i], n1, n2);
			}
		}
		//If the current nodes data is equal to the data of either of the nodes passed in, increment totalMatches.
		if(currentNode.data==n1.data || currentNode.data==n2.data) {
			totalMatches++;
		}

		// If this is the node, then we make finalLCA equal to the node we are currently on, and set totalMatches to 0 again.
		if (totalMatches==2) {
			finalLCA = currentNode;
			totalMatches=0;
		}
		return totalMatches;
	}

	public Node lowestCommonAncestor(Node root, Node n1, Node n2) {
		if (n1 != null && n2 != null) {
			if(n1.data == n2.data) {
				return n1;
			}
		}
		// Traverse through tree the tree and return the final LCA we get for a DAG.
		recurseTree(root, n1, n2);
		return finalLCA;
	}

	public void setFinalLCA(Node finalLCA) {
		LowestCommonAncestor.finalLCA = finalLCA;
	}
}