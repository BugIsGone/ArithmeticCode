package myClass_04;

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
 */
public class MyCode_02_Less_Money {
    public static void main(String[] args) {
        
    }

    public static int lessMoney(int[] arr) {
        if (arr.length == 0 || arr == null) throw new IllegalArgumentException("The arr's length is less than 1 or is empty! ");

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int cur = 0;
        int sum = 0;
        while(pQ.size() != 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(sum);
        }

        return 0;
    }
}
