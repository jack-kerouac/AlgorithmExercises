/**
 * 
 */
package graph.traversal.processors;

import graph.Graph.Vertex;
import graph.traversal.SearchTree;
import graph.traversal.AbstractSearcher.SearchState;

import java.util.Map;

public class ClassifyingEdgeProcessor implements EdgeProcessor {

	enum EdgeType {
		TREE, BACK, FORWARD, CROSS, FORWARD_OR_CROSS, UNCLASSIFIED;
	}

	@Override
	public void processEdge(Vertex from, Vertex to, SearchTree tree,
			Map<Vertex, SearchState> vertexStates) {

		ClassifyingEdgeProcessor.EdgeType type = EdgeType.UNCLASSIFIED;

		SearchState toState = vertexStates.get(to);

		if (tree.isParent(from, to))
			type = EdgeType.TREE;
		else if (toState == SearchState.DISCOVERED)
			type = EdgeType.BACK;
		else if (toState == SearchState.PROCESSED && tree.isAncestor(to, from))
			type = EdgeType.FORWARD;
		else if (toState == SearchState.PROCESSED
				&& tree.inDifferentSubTrees(to, from))
			type = EdgeType.CROSS;

		System.out.println("edge: " + from + "->" + to + " is a " + type
				+ " edge");
	}
}