package leetcode;

/**
 * @author shapemind
 * @create 2022-02-13 23:20
 */
public class Solution_1523_OddNumbers {
    public static void main(String[] args) {

    }

    public static int countOdds(int low, int high) {
        if (low % 2 == 0) {
            return (high - (low + 1)) / 2 + 1;
        } else {
            return (high - low) / 2 + 1;
        }
    }

    public static int comparator(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}



