package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph implements Iterable<Graph.Vertex> {

	public class Vertex implements Iterable<Vertex>, Comparable<Vertex> {
		private final int number;
		private final List<Vertex> outgoingEdges;

		public Vertex(int number) {
			super();
			this.number = number;
			this.outgoingEdges = new ArrayList<Vertex>();
		}

		public int getNumber() {
			return number;
		}

		// FLUID INTERFACE!
		public Vertex addEdge(Vertex to) {
			outgoingEdges.add(to);
			return to;
		}

		public Vertex addEdge(int to) {
			Vertex toV = vertices.get(to);
			return addEdge(toV);
		}

		public List<Vertex> getOutgoingEdges() {
			return outgoingEdges;
		}

		@Override
		public Iterator<Vertex> iterator() {
			return outgoingEdges.iterator();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + number;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (number != other.number)
				return false;
			return true;
		}

		private Graph getOuterType() {
			return Graph.this;
		}

		@Override
		public String toString() {
			return String.valueOf(number);
		}

		@Override
		public int compareTo(Vertex o) {
			if (number < o.getNumber())
				return -1;
			else if (number == o.getNumber())
				return 0;
			else
				return 1;
		}

	}

	private Map<Integer, Vertex> vertices;

	public Graph() {
		vertices = new TreeMap<Integer, Vertex>();
	}

	public Vertex addVertex(int number) {
		Vertex v = new Vertex(number);
		vertices.put(number, v);
		return v;
	}

	public Vertex getVertex(int number) {
		return vertices.get(number);
	}

	public void addEdge(int vertex1, int vertex2) {
		addUnidirectionalEdge(vertex1, vertex2);
	}

	private void addUnidirectionalEdge(int from, int to) {
		getVertex(from).addEdge(to);
	}

	@Override
	public Iterator<Vertex> iterator() {
		return vertices.values().iterator();
	}

	public int getVerticeCount() {
		return vertices.size();
	}

}
