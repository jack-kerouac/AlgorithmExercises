package graph.traversal.processors;

import graph.Graph.Vertex;
import graph.traversal.SearchTree;
import graph.traversal.AbstractSearcher.SearchState;

import java.util.Map;

public interface EdgeProcessor {

	public void processEdge(Vertex from, Vertex to, SearchTree parents,
			Map<Vertex, SearchState> vertexStates);

}
