package myClass_03;



/**
 * @author shapemind
 * @create 2021-11-11 17:13
 *
 * 两个单链表相交的一系列问题
 * 【题目】
 * 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1和head2，这两个链表可能相交，也可能不相交。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null即可。
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M)，额外空间复杂度请达到O(1)。
 */
public class MyCode_14_FindFirstIntersectNode {
    public static void main(String[] args) {

    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }
}
