/**
 * 
 */
package graph.traversal.processors;

import graph.Graph.Vertex;

public class PrintingVertexProcessor implements VertexProcessor {
	private final String prefix;

	public PrintingVertexProcessor(String prefix) {
		super();
		this.prefix = prefix;
	}

	@Override
	public void processVertex(Vertex vertex) {
		System.out.println(prefix + ": " + vertex);
	}
}