/**
 * 
 */
package graph.traversal.processors;

import graph.Graph.Vertex;
import graph.traversal.SearchTree;
import graph.traversal.AbstractSearcher.SearchState;

import java.util.Map;

public class CycleFindingEdgeProcessor implements EdgeProcessor {
	@Override
	public void processEdge(Vertex from, Vertex to, SearchTree tree,
			Map<Vertex, SearchState> vertexStates) {
		if (tree.isAncestor(from, to)
				&& vertexStates.get(to) == SearchState.DISCOVERED)
			System.out.println("found cycle from " + from + " to " + to);

		// THIS IS FROM THE BOOK:
		// Vertex p = parents.get(from);
		// if (!to.equals(p) && vertexStates.get(to) ==
		// SearchState.DISCOVERED)
		// System.out.println("found cycle from " + from + " to " + to);
	}
}