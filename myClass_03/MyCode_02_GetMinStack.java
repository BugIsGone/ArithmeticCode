package myClass_03;

import java.util.Stack;

/**
 * @author shapemind
 * @create 2021-10-13 11:41
 */

/*
实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。

【要求】
1．pop、push、getMin操作的时间复杂度都是O(1)。
2．设计的栈类型可以使用现成的栈结构。
 */
public class MyCode_02_GetMinStack {
    /*
        思路：建立两个栈，一个是的数据栈，一个是最小值栈。进入一个数据时，判断该数据是否的小于最小值栈的栈顶？是——>最小值栈
        压入当前数，数据压入数据栈；不是——>最小值栈再次压入当前栈顶元素，数据压入数据栈。最终数据栈和最小值栈的元素个数相同
     */
    public static class GetMinStack1 {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public GetMinStack1() {
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public int pop() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }

            this.dataStack.pop();
            return this.minStack.pop();
        }

        public void push(int newNum) {
            if (this.minStack.isEmpty()) {
                this.minStack.push(newNum);
            } else if (newNum < this.getMin()) {
                this.minStack.push(newNum);
            } else {
                int newMin = this.minStack.peek();
                this.minStack.push(newMin);
            }

            this.dataStack.push(newNum);
        }

        public int getMin() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }

            return this.minStack.peek();
        }
    }

    /*
        思路：建立两个栈，一个数据栈，一个最小值栈，大体思路和上面的方法类似，但最小值栈只有当数据小于当前栈顶元素才会入栈，
        所以最终最小值栈和数据栈的元素个数并不相同
     */
    public static class GetMinStack2 {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int value;

        public GetMinStack2() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.minStack.isEmpty()) {
                this.minStack.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.minStack.push(newNum);
            }
            this.dataStack.push(newNum);
        }

        public int pop() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            if (this.getMin() == this.dataStack.peek()) {
                value=this.minStack.pop();
            } else {
                value = this.getMin();
            }
            this.dataStack.pop();
            return value;
        }
        public int getMin() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }

            return this.minStack.peek();
        }
    }

    public static void main(String[] args) {
        GetMinStack1 getMinStack1 = new GetMinStack1();
        GetMinStack2 getMinStack2 = new GetMinStack2();
        getMinStack1.push(3);
        System.out.println(getMinStack1.getMin());
        getMinStack1.push(2);
        System.out.println(getMinStack1.getMin());
        System.out.println(getMinStack1.pop());
        System.out.println(getMinStack1.getMin());
        System.out.println("我是分割线");
        getMinStack2.push(4);
        System.out.println(getMinStack2.getMin());
        getMinStack2.push(5);
        System.out.println(getMinStack2.getMin());
        getMinStack2.push(3);
        System.out.println(getMinStack2.getMin());
        System.out.println(getMinStack2.pop());
        System.out.println(getMinStack2.pop());
        System.out.println(getMinStack2.getMin());
    }
}
