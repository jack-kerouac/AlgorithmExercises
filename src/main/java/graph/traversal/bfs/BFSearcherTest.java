package graph.traversal.bfs;

import graph.traversal.AbstractSearcherTest;
import graph.traversal.processors.PrintingEdgeProcessor;
import graph.traversal.processors.PrintingVertexProcessor;

import org.junit.Test;

public class BFSearcherTest extends AbstractSearcherTest {

	private BFSearcher searcher;

	@Test
	public void testDoBfs() {
		searcher = new BFSearcher(g, new PrintingVertexProcessor("entering"),
				new PrintingVertexProcessor("leaving "),
				new PrintingEdgeProcessor());
		System.out.println(searcher.doBfs(1));
	}
}
