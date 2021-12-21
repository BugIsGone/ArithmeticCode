package draft;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2020-11-12 12:04
 */
public class TestSmallSum {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,5,8,7};
//        System.out.println(arr);
        partition(arr, 0, arr.length - 1);
    }
    public static void partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);//这里的l++存疑
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        System.out.println(Arrays.toString(arr));
//        return new int[] { less + 1, more };
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
