package graph.traversal.dfs;

import graph.traversal.AbstractSearcherTest;
import graph.traversal.processors.ClassifyingEdgeProcessor;
import graph.traversal.processors.CycleFindingEdgeProcessor;
import graph.traversal.processors.PrintingVertexProcessor;

import org.junit.Ignore;
import org.junit.Test;

public class DFSearcherTest extends AbstractSearcherTest {

	private DFSearcher searcher;

	@Test
	public void testDoDfsRecWithClassification() {
		searcher = new DFSearcher(g, new PrintingVertexProcessor("entering"),
				new PrintingVertexProcessor("leaving "),
				new ClassifyingEdgeProcessor());
		System.out.println(searcher.doDfsRec(1));
		System.out.println();
	}
	
	@Test
	public void testDoDfsRecWithCycleFinding() {
		searcher = new DFSearcher(g, new PrintingVertexProcessor("entering"),
				new PrintingVertexProcessor("leaving "),
				new CycleFindingEdgeProcessor());
		System.out.println(searcher.doDfsRec(1));
		System.out.println();
	}

	@Test
	@Ignore
	public void testDoDfsStack() {
//		searcher = new DFSearcher(g, new PrintingVertexProcessor("entering"),
//				new PrintingVertexProcessor("leaving "),
//				new CycleFindingEdgeProcessor());
//		System.out.println(searcher.doDfsStack(1));
//		System.out.println();
	}

}
