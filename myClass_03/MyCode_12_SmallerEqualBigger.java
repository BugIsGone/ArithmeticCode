package myClass_03;

import basic_class_03.Code_12_SmallerEqualBigger;

/**
 * @author shapemind
 * @create 2021-10-25 15:44
 */
public class MyCode_12_SmallerEqualBigger {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) return head;
        //统计Node个数，并且创建对应长度数组
        Node cur = head;
        int i = 0;
        if (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];

        //对该Node数组进行赋值
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        //荷兰国旗处理
        arrPartition(nodeArr,pivot);

        //重新链接链表
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }

        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static Node listPartition2(Node head, int pivot) {
        if (head == null) return head;

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node cur = null;
        while (head != null) {
            cur = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = cur;
        }

        eT = eT == null ? bH : eT;
        sT = sT == null ? eH : sT;
        sT.next = eH;
        eT.next = sH;
        return sH;
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int index = 0;
        int large = nodeArr.length;

        while (index < large) {
            if (nodeArr[index].value < pivot) {
                swap (nodeArr, ++small, index++);//++small代表small区域的下一个数，是等于pivot的
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap (nodeArr, --large, index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int i, int j) {
        Node tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }
}
