package myClass_03;

/**
 * @author shapemind
 * @create 2021-10-10 15:41
 */
public class MyCode_01_ArrayToStackQueue {
    public static void main(String[] args) {

    }
}
/*
数组实现栈
 */
class ArrayStack {
    private Integer[] arr;
    private int index;

    private void arrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0 ");
        }

        arr = new Integer[initSize];
        index = 0;
    }

    private Integer peek() {
        if (index == 0) {
            return null;
        }

        return arr[--index];
    }

    private void push(int number) {
        if (index == arr.length) {
            throw new IllegalArgumentException("The stack is full");
        }

        arr[index++] = number;
    }

    private Integer pop() {
        if (index == 0) {
            throw new IllegalArgumentException("The stack is empty");
        }

        return arr[--index];
    }
}
/*
数组实现队列
 */
class ArrayQueue {
    private Integer[] arr;
    private Integer start;//当前队列的首位
    private Integer end;//当前队列的末尾
    private Integer size;

    private void initArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("InitSize is less than 0 !");
        }

        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    private Integer peek() {
        if (size == 0) {
            return null;
        }

        return arr[start];
    }

    private Integer poll() {
        if (size == 0) {
            throw new IllegalArgumentException("The queue is empty");
        }
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start++;
        return arr[tmp];
    }

    private void push(Integer number) {
        if (size == arr.length) {
            throw new IllegalArgumentException("The queue is full");
        }
        size++;
        arr[end] = number;
        end = end == arr.length - 1 ? 0 : end++;
    }
}