package draft;

/**
 * @author shapemind
 * @create 2021-12-17 9:57
 */
public class quicksort {
    public static void main(String[] args) {

    }

    private static void quicksort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            partition(arr, l, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
