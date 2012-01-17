package graph.traversal;

import graph.Graph.Vertex;

import java.util.Map;
import java.util.TreeMap;

public class SearchTree {

	private final Map<Vertex, Vertex> parents;

	public SearchTree() {
		parents = new TreeMap<Vertex, Vertex>();
	}

	public void addRelation(Vertex parent, Vertex child) {
		parents.put(child, parent);
	}

	public boolean isAncestor(Vertex descendant, Vertex ancestor) {
		Vertex nextAncestor = descendant;
		while (nextAncestor != null) {
			if (nextAncestor.equals(ancestor))
				return true;
			else
				nextAncestor = parents.get(nextAncestor);
		}
		return false;
	}

	public boolean inDifferentSubTrees(Vertex v1, Vertex v2) {
		return !(isAncestor(v1, v2) || isAncestor(v2, v1));
	}

	public boolean isParent(Vertex parent, Vertex child) {
		return parent.equals(parents.get(child));
	}
	
	@Override
	public String toString() {
		return "parent(x)=y: " + parents.toString();
	}
}
