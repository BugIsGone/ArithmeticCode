package myClass_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shapemind
 * @create 2021-10-13 21:59
 */
public class Mycode_03_StackAndQueueConvert {
    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        StackToQueue stackToQueue = new StackToQueue();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(5);
        System.out.println("我是分隔线");

        stackToQueue.push(5);
        stackToQueue.push(4);
        stackToQueue.push(3);
        stackToQueue.push(2);
        stackToQueue.push(1);
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());

    }

    /*
    Q:用队列结构实现栈结构？
    思路：用两个队列实现
        1.创建两个队列，queue和help；
        2.开始将数据push如queue
        3.peek()和poll()操作类似，都是将queue的数据除最后一个数据导入到help中，输出queue中的最后一个数据
        4.交换queue和help中的元素

    */
    public static class QueueToStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public QueueToStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        private void push(int newNum) {
            queue.add(newNum);
        }

        private int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }

            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        private int poll() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }

            while (queue.size() != 1) {
                help.add(queue.poll());
            }

            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }
    /*
    Q:用栈结构实现队列结构？
    思路：用两个栈实现
        1.创建两个栈push和pop栈
        2.在peek()、pop()、push()任一进行是否导数的判断

    PS：1.当pop栈中有数据，不能进行导数据；2.要进行导数据操作时，push栈务必清空
     */

    public static class StackToQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public StackToQueue() {
            push = new Stack<Integer>();
            pop = new Stack<Integer>();
        }

        private void push(int newNum) {
            push.push(newNum);
        }

        private int poll() {
            dataTransfer();
            if (pop.isEmpty()) {
                throw new RuntimeException("Your Queue is empty");
            }

            return pop.pop();
        }

        private void dataTransfer() {
            if (pop.isEmpty()) {
                while (push.size() != 0) {
                    pop.push(push.pop());
                }
            }
        }
    }
}
