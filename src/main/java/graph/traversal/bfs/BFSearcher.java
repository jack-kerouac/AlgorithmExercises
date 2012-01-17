package graph.traversal.bfs;

import graph.Graph;
import graph.Graph.Vertex;
import graph.traversal.AbstractSearcher;
import graph.traversal.SearchTree;
import graph.traversal.processors.EdgeProcessor;
import graph.traversal.processors.VertexProcessor;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSearcher extends AbstractSearcher {

	public BFSearcher(Graph g, VertexProcessor early, VertexProcessor late,
			EdgeProcessor edge) {
		super(g, early, late, edge);
	}

	public SearchTree doBfs(int startVertex) {
		Vertex start = g.getVertex(startVertex);

		Map<Vertex, SearchState> vertexStates = createAndInitStateMap();

		Queue<Vertex> queue = new LinkedList<Vertex>();

		vertexStates.put(start, SearchState.DISCOVERED);
		queue.add(start);

		return doBfs(vertexStates, queue);
	}

	private SearchTree doBfs(Map<Vertex, SearchState> vertexStates,
			Queue<Vertex> nextVertices) {
		SearchTree parents = new SearchTree();

		while (!nextVertices.isEmpty()) {
			Vertex v = nextVertices.remove();

			early.processVertex(v);

			// for all neighbors of v
			for (Vertex neighbor : v) {
				edge.processEdge(v, neighbor, parents, vertexStates);

				switch (vertexStates.get(neighbor)) {
				case UNDISCOVERED:
					vertexStates.put(neighbor, SearchState.DISCOVERED);
					nextVertices.add(neighbor);

					parents.addRelation(v, neighbor);

					break;
				case DISCOVERED:
					break;
				case PROCESSED:
					break;
				}
			}

			late.processVertex(v);

			vertexStates.put(v, SearchState.PROCESSED);
		}

		return parents;
	}
}
