package myClass_04;

import java.util.Arrays;

/**
 * @author shapemind
 * @create 2021-12-30 19:32
 * 二分法的拓展使用
 *
 * 【题目】在数组中找到一个局部最小的位置
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]，又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等。写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 *
 * 思路：
 * 1.先判断arr[0]位置和arr[length-1]位置是不是局部最小，是->返回
 * 2.arr[0]位置和arr[length-1]都不是局部最小，判断arr[length/2]及其两旁情况。
 * 设n=length/2，如果arr[n-1]<arr[n]<arr[n+1],则arr[0]到arr[n-1]之间存在局部最小，因为先↘，然后↗
 * 如果arr[n-1]>arr[n]>arr[n+1],则arr[n+1]到arr[length-1]之间存在局部最小，因为先↘，然后↗
 * 如果arr[n-1]>arr[n]<arr[n+1],则arr[n]就是局部最小
 */
public class MyCode_10_FindOneLessValueIndex {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 判断任意两边是不是局部最小
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        } else if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid ;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        System.out.println(Arrays.toString(arr));
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value:" + arr[index]);
    }
}
