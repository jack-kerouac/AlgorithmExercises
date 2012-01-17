/**
 * 
 */
package graph.traversal.processors;

import graph.Graph.Vertex;
import graph.traversal.SearchTree;
import graph.traversal.AbstractSearcher.SearchState;

import java.util.Map;

public class PrintingEdgeProcessor implements EdgeProcessor {
	@Override
	public void processEdge(Vertex from, Vertex to, SearchTree tree,
			Map<Vertex, SearchState> vertexStates) {
		System.out.println("edge: " + from + "->" + to);
	}
}