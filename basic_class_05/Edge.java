package basic_class_05;

public class Edge {
	public int weight;//权重
	public Node from;//从来里
	public Node to;//到哪里去

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
