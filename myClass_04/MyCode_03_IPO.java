package myClass_04;

import java.nio.file.CopyOption;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shapemind
 * @create 2021-11-24 14:23
 *
 * 贪心问题
 * 输入：
 * 参数1，正数数组costs
 * 参数2，正数数组profits
 * 参数3，正数k，只能做5个
 * 参数4，正数m
 * costs[i]表示i号项目的花费、profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目、m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：你最后获得的最大钱数
 */
public class MyCode_03_IPO {
    public static void main(String[] args) {
        int testTime = 0;
    }

    public static class Node {
        private double costs;
        private double profits;

        public Node (double costs, double profits) {
            this.costs = costs;
            this.profits = profits;
        }
    }

    public static class minCostsHeap implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.costs- o2.costs > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class maxProfitsHeap implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.profits - o2.profits > 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    //k表示最多可以做k个项目，w表示一开始拥有的资产
    public static double findMaximized (int k, double w, Node[] nodeArray) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new minCostsHeap());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new maxProfitsHeap());
        for (int i = 0; i < nodeArray.length; i++) {
            minCostQ.add(nodeArray[i]);
        }

        for (int i = 0; i < k; i++) {
            while(!minCostQ.isEmpty() && minCostQ.peek().costs <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().profits;
        }

        return w;
    }
}
