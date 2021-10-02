import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NodeTest {
	static Node firstNode;

	@BeforeAll
	static void declareNodes() {
		firstNode = new Node(1);
	}

	@Test
	public void constructorTest(){
		assertEquals(1,firstNode.data);
	}
	
	
	@Test
	public void assertLeftToNodeIsNull(){
		assertEquals(null,firstNode.left);
	}
	
	@Test
	public void assertRightToNodeIsNull(){
		assertEquals(null,firstNode.right);
	}
}