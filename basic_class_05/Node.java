package basic_class_05;

import java.util.ArrayList;

public class Node {
	public int value;//值
	public int in;//入度，有多少个箭头指向我
	public int out;//出度，多少个箭头指向外面
	public ArrayList<Node> nexts;//下一个Node有哪些=out
	public ArrayList<Edge> edges;//边有哪些=out

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
