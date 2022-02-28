package leetcode_basic.array_and_string;

/**
 * @author shapemind
 * @create 2022-02-14 11:25
 */
public class Solution_1991_PivotIndex {
    public static void main(String[] args) {

    }
}

class Comparator {
    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = calLeftSum(nums, i);
            int rightSum = calRightSum(nums, i);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    private int calRightSum(int[] nums, int index) {
        int sum = 0;
        for (int i = index + 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int calLeftSum(int[] nums, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

class Solution1 {
    public int findMiddleIndex(int[] nums) {
        //计算总和
        int total = 0;
        for (int num: nums) {
            total += num;
        }

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int postSum = total - preSum - nums[i];
            if (preSum == postSum) {
                return i;
            }
            preSum += nums[i];

        }
        return -1;
    }
}
