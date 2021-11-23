package myClass_04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shapemind
 * @create 2021-11-23 10:41
 *
 * 【题目】——随时找到数据流的中位数
 * 有一个源源不断地吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫MedianHolder的结构，MedianHolder可以
 * 随时取得之前吐出所有数的中位数。
 *
 * 【要求】
 * 1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
 * 2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)。
 */
public class MyCode_01_MadianQuick {
    public static void main(String[] args) {
        boolean isTrue = false;
        int testTimes = 200000;
        for (int i = 0; i < testTimes; i++) {
            int len = 35;
            int maxValue = 200;
            int[] arr = getRamdonArray(len, maxValue);
            MedianHolder medianHolder = new MedianHolder();
            for (int j = 0; j < arr.length; j++) {
                medianHolder.addNumber(arr[j]);
            }
            if (medianHolder.getMedian() != getMedianOfArray(arr)) {
                isTrue = true;
                printArray(arr);
                printMedianHolder(medianHolder);
                break;
            }
        }
        System.out.println(isTrue ? "Oh...what a fuck!" : "Today is a beautiful day!");
    }

    private static void printMedianHolder(MedianHolder medianHolder) {
        if (medianHolder == null) System.out.println("The Median is empty!");
        PriorityQueue<Integer> maxHeapStructure = medianHolder.maxHeap;
        PriorityQueue<Integer> minHeapStructure = medianHolder.minHeap;
        System.out.print("maxHeap: ");
        while(!maxHeapStructure.isEmpty()){
            System.out.print(maxHeapStructure.poll()+ "\t");
        }
        System.out.println();
        System.out.print("minHeap: ");
        while(!minHeapStructure.isEmpty()){
            System.out.print(minHeapStructure.poll()+ "\t");
        }
        System.out.println();
    }

    public static class MedianHolder {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());

        private void modifyTwoHeapsSize() {
            if (maxHeap.size() + 2 == minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (minHeap.size() + 2 == this.maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }

        private void addNumber(int newNumber) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(newNumber);
                return;
            }
            if (maxHeap.peek() >= newNumber) {
                maxHeap.add(newNumber);
            } else {
                if (minHeap.isEmpty()) {
                    minHeap.add(newNumber);
                    return;
                }
                if (minHeap.peek() > newNumber) {
                    maxHeap.add(newNumber);
                } else {
                    minHeap.add(newNumber);
                }
            }
            modifyTwoHeapsSize();
        }

        public Integer getMedian() {
            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            if ((maxHeapSize + minHeapSize) == 0) {
                return null;
            }

            Integer maxHeapHead = maxHeap.peek();
            Integer minHeapHead = minHeap.peek();

            if (((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }

            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        }
    }


    public static int[] getRamdonArray(int size, int maxValue) {
        int[] res = new int[(int)(Math.random() * size) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int)(Math.random() * maxValue);
        }

        return res;
    }

    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);

        if ((newArr.length & 1) == 0) {
            return (newArr[(newArr.length - 1)/ 2] + newArr[newArr.length / 2]) / 2;
        } else {
            return newArr[newArr.length / 2];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
