package leetcode_practise;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-12-23 18:55
 * 题目：
 * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
 * 示例：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]  输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class code0053_MaximumSubarray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] subArray = new int[i + 1];
            
    }
}
