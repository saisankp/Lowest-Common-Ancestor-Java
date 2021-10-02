import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LCATest {

	LowestCommonAncestor tree;
	
	@BeforeEach
	void getNewTree() {
		tree = new LowestCommonAncestor();
	}
	
	@Test
	void testNoNode() {
		assertEquals(-1,tree.findLCA(0, 0));	
	}
	
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
	
	@Test
	void testNodesWithSameParentNodes() { //i.e. nodes with the same depth!
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
		assertEquals(2, tree.findLCA(4,5));
	}
	
	@Test
	void testNodesWithDifferentParentNodes() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
		assertEquals(1, tree.findLCA(4,6));
	}
	
	@Test
	void testNodesWithDifferentDepths() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
		assertEquals(1, tree.findLCA(3,4));
	}

	
	@Test
	void testNodesAsParentAndChild() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
		assertEquals(2, tree.findLCA(2,4));
	}
	
	@Test
	void testInvalidTree() {
        tree.root = new Node(1);
		assertEquals(-1, tree.findLCA(1,0));
	}
	
	@Test
	void testSameNode() {
        tree.root = new Node(1);
		assertEquals(1, tree.findLCA(1,1));
	}
}