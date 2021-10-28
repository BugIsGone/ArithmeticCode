package myClass_03;

/**
 * @author shapemind
 * @create 2021-10-26 22:53
 *
 * 【题目一】
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，rand指针是Node类中新增的指针，
 * 这个指针可能指向链表中的任意一个节点，也可能指向null。给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个
 * 函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 *
 * 【题目二】
 * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为O(N)内完成原问题要实现的函数。
 */
public class MyCode_13_CopyListWithRandom {
    public static void main(String[] args) {

    }

    public static class Node {
        private int value;
        private Node next;
        private Node rand;

        public Node (int data) {
            this.value = data;
        }
    }
}
