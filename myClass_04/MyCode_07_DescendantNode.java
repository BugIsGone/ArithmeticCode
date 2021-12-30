package myClass_04;

import basic_class_04.Code_07_DescendantNode;

/**
 * @author shapemind
 * @create 2021-12-29 23:34
 *
 * 题目：在二叉树中,中序遍历下（快速）找到一个节点的后继节点
 * 例子：一种新的二叉树节点类型如下：
 * public class Node {
 *     public int value;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 *
 *     public Node(int data) {
 *         this.value = data;
 *     }
 * }
 *
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向
 * 自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点node，请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中，
 * node的下一个节点叫作node的后继节点。
 *
 * 思路：
 * 情况1：如果node有右子树，则右子树最左边的节点就是后继节点
 * 情况2：如果node没有右子树，判断node是不是node父节点的左孩子节点，如果是左孩子节点，则node父节点就是的node的后继结点；如果node是node父节点
 * 的右孩子，则继续向上寻找后继结点，直至当前node，是node父节点p的左节点
 * 情况3：如果情况2一直向上寻找直至为null，则说明该node已经没有后继结点
 */
public class MyCode_07_DescendantNode {
    public static class Node {
        Node parent;
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getMaxLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node)  {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getMaxLeft(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.right = new Node(4);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.right = new Node(10);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.right; // 10's next is null
        Node tmp = getNextNode(test);
        System.out.println(test.value + " next: " + tmp);

    }

}
