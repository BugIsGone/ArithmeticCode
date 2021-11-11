package myClass_03;

import javax.sound.midi.SoundbankResource;
import java.util.HashMap;

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
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        System.out.println("========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next;

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(head);
        printRandLinkedList(res2);
    }

    public static class Node {
        private int value;
        private Node next;
        private Node rand;

        public Node (int data) {
            this.value = data;
        }
    }

    //【题目1】
    public static Node copyListWithRand1 (Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur  = head;
        while (cur != null) {
            //此时value中缺乏了next和rand的指向
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).rand = map.get(cur.rand);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }

    //【题目2】：【1】-【2】-【3】-【4】变成【1】-【1'】-【2】-【2'】-【3】-【3'】-【4】-【4'】,然后变更指针指向完成
    //rand、next指针的复制
    public static Node copyListWithRand2 (Node head) {
        if (head == null) return null;
        Node cur = head;
        Node next = null;
        //【1'】、【2'】、【3'】、【4】连接到原来的链表中
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //拷贝rand
        cur = head;
        while (cur != null) {
            //当cur.rand为null时，cur.rand.next就会报错，此写法不对。cur.next.rand = cur.rand.next;
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }

        //链表和链表copy分离，实际是把next指针纠正
        cur = head;
        Node res = cur.next;
        //搞不懂这里为什么错
        while (cur != null) {
            cur.next = cur.next.next;
            res.next = cur.next == null ? null : cur.next.next;
            cur = cur.next.next;
        }
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    //打印链表看看
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        cur = head;
        System.out.println();
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print((cur.rand == null ? "-" : cur.rand.value) + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
