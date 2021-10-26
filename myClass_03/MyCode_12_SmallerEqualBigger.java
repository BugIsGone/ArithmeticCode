package myClass_03;



/**
 * @author shapemind
 * @create 2021-10-25 15:44
 *
 * 【题目1】
 * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于
 * pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，pivot=3。调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满足左部分都是小于3的节点，
 * 中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
 *
 * 【题目2】
 * 在原问题的要求之上再增加如下两个要求。在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的
 * 先后次序一致。例如：链表9->0->4->5->1，pivot=3。调整后的链表是0->1->9->4->5。在满足原问题要求的同时，左部分节点从左到右为0、1。
 * 在原链表中也是先出现0，后出现1；中间部分在本例中为空，不再讨论；右部分节点从左到右为9、4、5。在原链表中也是先出现9，然后出现4，
 * 最后出现5。如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
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

    //题目1
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

    //题目2
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

        /*
        这段代码发生错误的原因，在于没有建立sT到eH，eT到bH之间连接，实际就是考虑情况不够全面导致的
        eT = eT == null ? bH : eT;
        sT = sT == null ? eH : sT;
        sT.next = eH;
        eT.next = sH;
         */

        //small and equal connected
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        //all connected
        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
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
