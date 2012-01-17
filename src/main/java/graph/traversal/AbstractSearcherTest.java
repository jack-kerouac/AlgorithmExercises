package graph.traversal;

import graph.Graph;

import org.junit.Before;

public abstract class AbstractSearcherTest {

	protected Graph g;

	@Before
	public void setUp() throws Exception {
		g = new Graph();

		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);

		g.getVertex(1).addEdge(2).addEdge(3).addEdge(4).addEdge(2);
		g.getVertex(1).addEdge(5).addEdge(4);
		g.getVertex(5).addEdge(1);

		g.getVertex(2).addEdge(2);
		// g.getVertex(1).addEdge(2);

		g.getVertex(1).addEdge(4);
	}

}
