package myClass_03;

/**
 * @author shapemind
 * @create 2021-10-25 14:14
 */
public class MyCode_11_IsPalindromeList2 {
    public static void main(String[] args) {

    }

    //This method needs O(1) extra space
    public static boolean isPalindromeList3(Node head) {
        /*
        * 到底head != null 要不要加入判断条件？这个条件是干嘛的？判断输入的Node不满足条件时就退出。那当head = null算不算是
        * 特殊情况，明显是属于的。而且这种情况就应该返回的true
        */
        if (head == null || head.next == null) return true;

        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //改变链表方向
        fastPointer = slowPointer.next;
        slowPointer.next = null;
        Node tmp = null;
        while (fastPointer != null) {//用一个暂时变量存储fastPointer.next的值
            tmp = fastPointer.next;
            fastPointer.next = slowPointer;
            slowPointer = fastPointer;
            fastPointer = tmp;
        }

        //进行对比
        tmp = slowPointer;
        fastPointer = head;
        boolean isPalindromeListFlag = true;
        while (slowPointer.next != null || fastPointer.next != null) {
            if (slowPointer.data != fastPointer.data) {
                isPalindromeListFlag = false;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        //对比后要进行复位
        fastPointer = tmp.next;
        tmp.next = null;
        while (fastPointer != null) {
            slowPointer = fastPointer.next;
            fastPointer.next = tmp;
            tmp = fastPointer;
            fastPointer = slowPointer;
        }
        return isPalindromeListFlag;
    }
    public static class Node {
        private int data;
        private Node next;

        public Node(int value) {
            this.data = value;
        }
    }
}
