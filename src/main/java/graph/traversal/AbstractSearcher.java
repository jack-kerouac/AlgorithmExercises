package graph.traversal;

import graph.Graph;
import graph.Graph.Vertex;
import graph.traversal.processors.EdgeProcessor;
import graph.traversal.processors.VertexProcessor;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractSearcher {

	public enum SearchState {
		UNDISCOVERED, DISCOVERED, PROCESSED;
	}

	protected final Graph g;
	protected final VertexProcessor early;
	protected final VertexProcessor late;
	protected final EdgeProcessor edge;

	public AbstractSearcher(Graph g, VertexProcessor early, VertexProcessor late,
			EdgeProcessor edge) {
		this.g = g;
		this.early = early;
		this.late = late;
		this.edge = edge;
	}

	protected Map<Vertex, SearchState> createAndInitStateMap() {
		Map<Vertex, SearchState> vertexStates = new TreeMap<Vertex, SearchState>();
		for (Vertex v : g)
			vertexStates.put(v, SearchState.UNDISCOVERED);
		return vertexStates;
	}

}