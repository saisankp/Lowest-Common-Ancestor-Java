import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NodeTest {
	static Node firstNode;

	@BeforeAll
	static void declareNodes() {
		firstNode = new Node(1, new Node [] {new Node(9, null), new Node(8,null)});
	}

	@Test
	public void constructorTest(){
		assertEquals(1,firstNode.data);
	}
}