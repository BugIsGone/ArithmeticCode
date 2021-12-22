package myClass_04;

import java.util.Stack;

/**
 * @author shapemind
 * @create 2021-11-24 16:01
 */
public class MyCode_05_PreInPosTraversal {
    public static void main(String[] args) {

    }
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node (int data) {
            this.value = data;
        }
    }

    //递归：先序遍历，中左右
    public static void preOrderRecur (Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归：中序遍历，左中右
    public static void inOrderRecur (Node head) {
        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    //递归：后序遍历，左右中
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    //非递归：先序遍历，中左右
    public static void preOrderUnRecur (Node head) {
        System.out.println("Pre-order: ");
        if (head != null) {
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.add(head);
            while (!nodeStack.isEmpty()){
                head = nodeStack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    nodeStack.add(head.right);
                }
                if (head.left != null) {
                    nodeStack.add(head.left);
                }
            }
        }
        System.out.println();
    }

    //非递归：中序遍历，左中右
    public static void inOrderUnRecur (Node head) {
        System.out.println("In-Order: ");
        if (head != null) {
            Stack<Node> nodeStack = new Stack<Node>();
            while (!nodeStack.isEmpty() || head != null) {
                if (head != null) {
                    nodeStack.add(head);
                    head = head.left;
                } else {
                    head = nodeStack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    //非递归：后序遍历1，左右中
    public static void posOrderUnRecur1 (Node head) {
        if (head != null) {
            System.out.println("posOrderUnRecur1: ");
            Stack<Node> nodeStack = new Stack<>();
            Stack<Node> helpStack = new Stack<>();
            nodeStack.add(head);
            while(!nodeStack.isEmpty()) {
                head = nodeStack.pop();
                helpStack.add(head);

                if (head.left != null) {
                    helpStack.add(head.left);
                }
                if (head.right != null) {
                    helpStack.add(head.right);
                }
            }

            while (!helpStack.isEmpty()) {
                System.out.println(helpStack.pop().value + " ");
            }
        }
    }

    //非递归：后续遍历2，左右中
}