package graph.traversal.dfs;

import graph.Graph;
import graph.Graph.Vertex;
import graph.traversal.AbstractSearcher;
import graph.traversal.SearchTree;
import graph.traversal.processors.EdgeProcessor;
import graph.traversal.processors.VertexProcessor;

import java.util.Map;

public class DFSearcher extends AbstractSearcher {

	public DFSearcher(Graph g, VertexProcessor early, VertexProcessor late,
			EdgeProcessor edge) {
		super(g, early, late, edge);
	}

	public SearchTree doDfsRec(int startVertex) {
		Vertex start = g.getVertex(startVertex);

		Map<Vertex, SearchState> vertexStates = createAndInitStateMap();

		SearchTree parents = new SearchTree();

		doDfsRec(start, vertexStates, parents);

		return parents;
	}

	private void doDfsRec(Vertex v, Map<Vertex, SearchState> vertexStates,
			SearchTree parents) {
		vertexStates.put(v, SearchState.DISCOVERED);

		early.processVertex(v);
		for (Vertex neighbor : v) {
			switch (vertexStates.get(neighbor)) {
			case UNDISCOVERED:
				parents.addRelation(v, neighbor);
				edge.processEdge(v, neighbor, parents, vertexStates);
				doDfsRec(neighbor, vertexStates, parents);
				break;
			case DISCOVERED:
				edge.processEdge(v, neighbor, parents, vertexStates);
				break;
			case PROCESSED:
				edge.processEdge(v, neighbor, parents, vertexStates);
				break;
			}
		}

		late.processVertex(v);

		vertexStates.put(v, SearchState.PROCESSED);
	}

	// +++ DFS STACK ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//	public SearchTree doDfsStack(int startVertex) {
//		Vertex start = g.getVertex(startVertex);
//
//		Map<Vertex, SearchState> vertexStates = createAndInitStateMap();
//
//		Stack<Vertex> stack = new Stack<Vertex>();
//
//		vertexStates.put(start, SearchState.DISCOVERED);
//		stack.push(start);
//
//		return doDfsStack(vertexStates, stack);
//	}
//
//	private SearchTree doDfsStack(Map<Vertex, SearchState> vertexStates,
//			Stack<Vertex> nextVertices) {
//		SearchTree parents = new SearchTree();
//
//		while (!nextVertices.isEmpty()) {
//			Vertex v = nextVertices.pop();
//
//			early.processVertex(v);
//			for (Vertex neighbor : v) {
//				edge.processEdge(v, neighbor, parents, vertexStates);
//
//				switch (vertexStates.get(neighbor)) {
//				case UNDISCOVERED:
//					parents.addRelation(v, neighbor);
//					nextVertices.push(neighbor);
//					vertexStates.put(v, SearchState.DISCOVERED);
//
//					break;
//				case DISCOVERED:
//					break;
//				case PROCESSED:
//					break;
//				}
//			}
//
//			late.processVertex(v);
//
//			vertexStates.put(v, SearchState.PROCESSED);
//		}
//
//		return parents;
//	}

}
