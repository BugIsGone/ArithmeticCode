package myClass_01;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-10-09 12:47
 */
public class MyCode_11_MaxGap {
    public static void main(String[] args) {
        int testTime = 1000000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSucceed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                isSucceed = false;
                break;
            }
        }
        System.out.println(isSucceed ? "Nice!" : "Fucking fucked!");
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) return null;

        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);

        return res;
    }

    private static int comparator(int[] arr) {
        if (arr.length < 2 || arr == null) return 0;

        Arrays.sort(arr);
        int gap = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            gap = Math.max(arr[i] - arr[i - 1], gap);
        }
        return gap;
    }

    private static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) return 0;

        int len = arr.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        if (min == max) return 0;

        boolean[] hasNum = new boolean[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        int i = 0;
        for (; i <= len ; i++) {
            if (hasNum[i]) {
                res = Math.max(res, arr[i] - lastMax);
                lastMax = arr[i];
            }
        }

        return res;
    }

    private static int bucket(long num, long len, long min, long max) {
        return (int)((num - min) / (max - min) * len);
    }
}
