package myClass_04;

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
 * 1.如果node有右子树，则右子树最左边的节点就是后继节点
 * 2.如果node没有右子树，判断node是不是node父节点的左孩子节点，如果是左孩子节点，则
 */
public class MyCode_07_DescendantNode {
    public static void main(String[] args) {

    }

    public static int comparator()
}
