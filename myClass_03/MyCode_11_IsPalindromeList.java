package myClass_03;

import java.util.Stack;

/**
 * @author shapemind
 * @create 2021-10-19 15:30
 *
 * 【题目】
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1，返回true。
 * 1->2->2->1，返回true。Preferences
 * 15->6->15，返回true。
 * 1->2->3，返回false。
 * 进阶：
 * 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 *
 * 【解1】空间复杂度的O(N)，时间复杂度O(N)
 * 准备的一个栈，把数据压入栈中，然后依次弹出栈，弹出栈和先前链表元素一一对比
 *
 * 【解2】空间复杂度的O(N)，解2的空间复杂度度实际比解1要少一半，时间复杂度O(N)
 * 1.准备的两个指针，一个快指针——每次走两步，一个慢指针——每次走一步。当快指针指向链表最后一个元素时，慢指针的恰巧来到链表中点；
 * 2.将慢指针后面元素，从慢指针所在位置向最后位置，一次压入栈中。此时所用栈的空间比解1少一半，因为只需要压入一半的数据
 * 3.将栈中的元素弹出，和慢指针前面部分进行比对
 *
 * 【解3】（符合本题条件的解法）时间复杂度达到O(N)，额外空间复杂度达到O(1)
 * 1.准备两个快慢指针，快指针每次走两步，慢指针每次走一步，当快指针来到链表末尾的时候，快慢指针都停下，此时慢指针出于链表中点
 * 2.将慢指针后面的部分链表逆序。如1——>2——>3——>2——>1,会变成1——>2——>3<——2<——1
 * 3.左右两边进行对比，如果都相同，就是回文
 */
public class MyCode_11_IsPalindromeList {
    public static class Node {
        private int data;
        private Node node;

        public Node(int value) {
            this.data = value;
        }
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> nodeStack = new Stack<>();

        return true;
    }
    public static void main(String[] args) {
        
    }
}
