package basic_class_05;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer,Node> nodes;//点集,Integer指点的编号
	public HashSet<Edge> edges;//边集

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
