package myClass_01;


import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-09-21 23:01
 */
public class MyCode_04_QuickSort {
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 200;
        int testTime = 1000000;
        boolean isSucceed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1, arr2)){
                isSucceed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }

        System.out.println(isSucceed ? "Nice!" : "Fucking fucked");

        int[] arr = generateArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null) || (arr1.length != arr2.length)) return false;

        if (arr1 == null && arr2 == null) return true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;


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
        int[] res = new int[(int) (Math.random() * (maxSize + 1))];

        for (int i = 0; i < res.length; i++) {
            res[i] = (int) ((maxValue + 1) * Math.random()) - (int) (Math.random() * maxValue);
        }
        return res;
    }
}
