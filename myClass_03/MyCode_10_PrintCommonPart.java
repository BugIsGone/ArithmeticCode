package myClass_03;



/**
 * @author shapemind
 * @create 2021-10-19 14:33
 *
 * 【题目】
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class MyCode_10_PrintCommonPart {
    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printLinkedlist (Node node) {
        System.out.print("Linkedlist: ");
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.print("Comman part: ");
        while (head1 != null && head2 !=null) {
            if (head1.value == head2.value) {
                System.out.print(head1.value + "\t");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedlist(node1);
        printLinkedlist(node2);
        printCommonPart(node1, node2);
    }
}