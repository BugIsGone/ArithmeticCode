package myClass_01;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-09-08 8:41
 */
public class MyCode_12_SmallSum {
    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 200;
        int maxValue = 200;
        boolean isSucceed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            if (smallSum(arr1) != comparator(arr2)) {
                isSucceed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(isSucceed ? "Nice!" : "Fucking fucked!");
    }

    private static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) return 0;

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    private static int smallSum(int[] arr) {
        if (arr.length < 2 || arr == null) return 0;

        return smallSum(arr, 0, arr.length - 1);
    }

    private static int smallSum(int[] arr, int l, int r) {
        if (l == r) return 0;

        int mid = l + ((r - l) >> 1);
        return smallSum(arr, l, mid) + smallSum(arr, mid + 1, r) + sum(arr, l, mid, r);
    }

    private static int sum(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) return null;

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static int[] generateArray(int maxSize, int maxValue) {
        int[] res = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < res.length; i++) {
            res[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return res;
    }
}
