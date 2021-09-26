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
        
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        while (l < r){
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l ,r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r ;

        while(l < more){
            if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else {
                l++;
            }
        }
        swap(arr, more, r);

        return new int[]{less + 1, ++more};
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
