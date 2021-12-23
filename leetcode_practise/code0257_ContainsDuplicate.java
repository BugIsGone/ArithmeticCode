package leetcode_practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author shapemind
 * @create 2021-12-22 22:29
 */
public class code0257_ContainsDuplicate {
    public static void main(String[] args) {
        boolean isTrue = containsDuplicate3(new int[]{1, 2, 3, 4});
        System.out.println(isTrue);
    }

    /**
     * map
     * 方法1：map.put()的值不为null
     * 方法2：判断长度不等
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }

    /*
    set方法：
    方法1：判断hashSet的add()是否为true —— <最快>
    访法2：判断hashSet的size()和nums.length是否一致
     */
    public static boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    /*
    思路：先排序，然后相邻两个值不存在相同
     */
    public static boolean containsDuplicate4(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /*
    思路：利用IntStream进行炫技
     */
    public static boolean containsDuplicate5(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    public static boolean comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}
