package myClass_01;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-09-02 13:00
 */
public class class01_summary {
    public static void main(String[] args) {
    }

    //造数组
    private static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return null;
    }

    //拷贝数组1
    private static int[] copyArr1(int[] arr) {
        if (arr == null) return null;

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    //拷贝数组2
    private static int[] copyArr2(int[] arr) {

        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);

        return res;
    }

    //对数器
    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    //验证操作1
    private static boolean isEqual1(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        } else if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        } else if (arr1 == null && arr2 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    //验证操作2
    private static boolean isEqual2(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    //交换操作1（初级版）
    private static void swap1(int[] arr, int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    /*
    交换操作2（初级版）
    [注意事项]：1.该交换方式中，i和j必须是不一样的，否则会造成数组中该元素被修改成0
     */
    private static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //打印数组1
    private void printArr1(int[] arr) {
        if (arr == null) return;

        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //打印数组2
    private void printArr2(int[] arr){
        System.out.println(Arrays.toString(arr));
    }


    //bubbleSort
    private void bubblesort(int[] arr){
        if(arr.length < 2 || arr == null) return;
        //pattern 1：先排好前面的
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - i - 1; j >= 0; j--){
                if (arr[j] > arr[j + 1]){
                    swap1(arr, j, j + 1);
                }
            }
        }
        //pattern 2：先排好后面的
        for (int e = arr.length - 1; e > 0 ; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) swap1(arr, i, i + 1);
            }
        }
    }

    //insertionSort
    private void insertionSort(int[] arr){
        if (arr.length < 2 || arr == null) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j++) {
                swap1(arr, j, j + 1);
            }
        }
    }

    //mergeSort
    private void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) return;

        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r){
        if (l == r) return;
        int m = l + ((r - l) >> 1);
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;

        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= m){
            help[i++] = arr[p1++];
        }

        while(p2 <= r){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }
}
