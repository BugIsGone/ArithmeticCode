package myClass_04;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shapemind
 * @create 2021-11-23 17:55
 *
 * 【题目】：一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，
 * 都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板？
 *
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60.金条要分成10,20,30三个部分。
 * 如果，先把长度60的金条分成10和50，花费60，再把长度50的金条分成20和30，花费50一共花费110铜板。
 * 但是如果，先把长度60的金条分成30和30，花费60，再把长度30金条分成10和20，花费30，一共花费90铜板。
 *
 * 输入一个数组，返回分割的最小代价。
 *
 * 思路：哈夫曼编码、动态规划、贪心策略
 */
public class MyCode_02_Less_Money {
    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // minHeap1
        PriorityQueue<Integer> minHQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minHQ1.add(arrForHeap[i]);
        }
        System.out.print("minHQ1: ");
        while (!minHQ1.isEmpty()) {
            System.out.print(minHQ1.poll() + " ");
        }
        System.out.println();

        //minHeap2
        PriorityQueue<Integer> minHQ2 = new PriorityQueue<>(new minHeapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minHQ2.add(arrForHeap[i]);
        }
        System.out.print("minHQ2: ");
        while (!minHQ2.isEmpty()) {
            System.out.print(minHQ2.poll() + " ");
        }
        System.out.println();

        //maxHeap
        PriorityQueue<Integer> maxHQ = new PriorityQueue<>(new maxHeapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxHQ.add(arrForHeap[i]);
        }
        System.out.print("maxHQ: ");
        while (!maxHQ.isEmpty()) {
            System.out.print(maxHQ.poll() + " ");
        }
    }

    public static int lessMoney(int[] arr) {
        if (arr.length == 0 || arr == null) throw new IllegalArgumentException("The arr's length is less than 1 or is empty! ");

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int cur = 0;
        int sum = 0;
        while(pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class minHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
