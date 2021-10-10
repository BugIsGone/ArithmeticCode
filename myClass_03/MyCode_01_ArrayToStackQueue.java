package myClass_03;

/**
 * @author shapemind
 * @create 2021-10-10 15:41
 */
public class MyCode_01_ArrayToStackQueue {
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private Integer[] arr;
    private int index;

    private void arrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0 ");
        }

        arr = new Integer[initSize];
        index = 0 ;
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
