package leetcode_practise;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author shapemind
 * @create 2021-12-21 19:36
 * <p>
 * 题目：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
 * 每种输入只有一个答案
 * 进阶：时间复杂度为O(n的2次方)的算法吗
 */
public class code0001_TwoSum {
    public static void main(String[] args) {
        int[] res = twosum2(new int[]{3, 4, 6}, 9);
        System.out.println(Arrays.toString(res));
    }

    /***
     * 使用了哈希表获取key为O(1)的特性
     * @param nums 输入
     * @param target 目标和
     * @return 数组
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 20) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 使用了双指针left和right、哈希表，时间复杂度是O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (left < right) {
            int lnums = nums[left];
            int rnums = nums[right];
            int lnumsAnswer = target - lnums;
            int rnumsAnswer = target - rnums;
            if (map.containsKey(lnumsAnswer)) {
                return new int[]{map.get(lnumsAnswer), left++};
            } else {
                map.put(lnums, left++);
            }
            if (map.containsKey(rnumsAnswer)) {
                return new int[]{map.get(rnumsAnswer), right--};
            } else {
                map.put(rnums, right--);
            }
        }
        return null;
    }

    public static int[] twoSumSortBinarySearch(int[] nums, int target) {
        int[] res = new int[2];
        int[] resVal = new int[2];
        int[] copiedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int n1 = -1;
        for (int i = 0; i < nums.length; i++) {

        }
    }

    //比较器
    public static int[] comparator(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return null;
    }


}
