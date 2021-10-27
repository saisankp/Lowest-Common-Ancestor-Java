import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LCATest {

	private static Node one, two, three, four, five, seven, eight, nine, ten;
	private static LowestCommonAncestor LCA;

	/**
	 * Let's make an example DAG like this for this test file.
	 * N.B. -> | and V is an arrow pointing to a number
	 *    
	 *     1
	 *     |
	 *     V
	 *     2
	 *   /   \
	 *  V     V
	 *  3      5
	 *  | 	 / | \
	 *  V    V V V
	 *  4    7 8 9
	 *   \  /
	 *    VV
	 *    10
	 */

	@BeforeAll
	static void setNodes() {
		LCA = new LowestCommonAncestor();
		nine = new Node(9,null);
		ten = new Node(10, null);
		eight = new Node(8, null);
		seven = new Node(7, new Node[] {ten});
		four = new Node(4, new Node[] {ten});
		three = new Node(3, new Node[] {four});
		five = new Node(5, new Node[] {nine, eight, seven});
		two = new Node(2, new Node[] {three, five});
		one = new Node(1, new Node[] {two});
	}

	@BeforeEach
	void resetFinalLCA() {
		LCA.setFinalLCA(null);
	}

	@Test
	void testWithNull() {
		assertEquals(null, LCA.lowestCommonAncestor(null, null, null));
		assertEquals(null, LCA.lowestCommonAncestor(null, null, seven));
		assertEquals(null, LCA.lowestCommonAncestor(null, seven, null));	
	}

	@Test
	void testLCAWithImaginaryNode() {
		Node imaginary = new Node(-1,null);
		assertEquals(null, LCA.lowestCommonAncestor(one,imaginary, nine));
	}

	@Test
	void testNodesWithSameDepthSameParent() {
		assertEquals(five, LCA.lowestCommonAncestor(one,nine,eight));
		assertEquals(five, LCA.lowestCommonAncestor(one,seven,eight));
		assertEquals(five, LCA.lowestCommonAncestor(one,seven,nine));
	}

	@Test
	void testNodesWithSameDepthDifferentParent() {
		assertEquals(two, LCA.lowestCommonAncestor(one,four, nine));
		assertEquals(two, LCA.lowestCommonAncestor(one,four, eight));
		assertEquals(two, LCA.lowestCommonAncestor(one,four, seven));
	}

	@Test
	void testNodesWithDifferentDepthDifferentParent() {
		assertEquals(five, LCA.lowestCommonAncestor(one,ten,nine));
		assertEquals(three, LCA.lowestCommonAncestor(one,ten,three));
		assertEquals(five, LCA.lowestCommonAncestor(one,ten,five));
	}

	@Test
	void testNodesWithOneEqualToLCA() {
		assertEquals(five, LCA.lowestCommonAncestor(one,five,seven));
		assertEquals(three, LCA.lowestCommonAncestor(one,three,four));
		assertEquals(two, LCA.lowestCommonAncestor(one,three,two));
	}
		
	@Test
	void testSameNodes() {
		assertEquals(five, LCA.lowestCommonAncestor(one,five,five));
		assertEquals(two, LCA.lowestCommonAncestor(one,two,two));
		assertEquals(seven, LCA.lowestCommonAncestor(one,seven,seven));
	}
	
	@Test
	void testDAG() {
		assertEquals(four, LCA.lowestCommonAncestor(one,ten,four));
		assertEquals(two, LCA.lowestCommonAncestor(one,ten,one));
		assertEquals(seven, LCA.lowestCommonAncestor(one,ten,seven));
	}
}