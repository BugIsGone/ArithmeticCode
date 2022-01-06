package basic_class_05;

/**
 * 下面创建图的形式
 * [边权, from, to]
 */
public class GraphGenerator {
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {//matrix row
			Integer from = matrix[i][0];
			Integer to = matrix[i][1];
			Integer weight = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {//fromNode exist?
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {//toNode exist?
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);//create edge
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
