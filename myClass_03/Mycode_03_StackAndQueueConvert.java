package myClass_03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shapemind
 * @create 2021-10-13 21:59
 */
public class Mycode_03_StackAndQueueConvert {
    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(5);
        System.out.println(queueToStack.peek());
        System.out.println(queueToStack.poll());
        System.out.println(queueToStack.poll());
        System.out.println(queueToStack.poll());
        System.out.println(queueToStack.poll());
        System.out.println(queueToStack.poll());
    }

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
}
