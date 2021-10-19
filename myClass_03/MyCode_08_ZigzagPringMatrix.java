package myClass_03;


/**
 * @author shapemind
 * @create 2021-10-18 11:41
 */
/*
【题目】
给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
1 2 3 4
5 6 7 8
9 10 11 12
“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
【要求】
额外空间复杂度为O(1)。
 */
public class MyCode_08_ZigzagPringMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigzag1(matrix);
    }

    public static void printMatrixZigzag(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (row1 <= endR) {
            printLevel(matrix, row1, col1, row2, col2, fromUp);
            row1 = col1 == endC ? ++row1 : row1;
            col1 = col1 == endC ? col1 : ++col1;
            col2 = row2 == endR ? ++col2 : col2;
            row2 = row2 == endR ? row2 : ++row2;
            fromUp = !fromUp;
        }
        System.out.println();
    }



    private static void printLevel(int[][] matrix, int topR, int topC, int downR, int downC, boolean fromUp) {
        if (fromUp) {
            while (topR <= downR) {
                System.out.print(matrix[topR++][topC--] + " ");
            }
        } else {
            while (downR >= topR) {
                System.out.print(matrix[downR--][downC++] + " ");
            }
        }
    }

    public static void printMatrixZigzag1(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;

        while (row1 <= endR) {
            printLevel1(matrix, row1, col1, row2, col2, fromUp);
            row1 = col1 == endC ? ++row1 : row1;
            col1 = col1 == endC ? col1 : ++col1;
            col2 = row2 == endR ? ++col2 : col2;
            row2 = row2 == endR ? row2 : ++row2;
            fromUp = !fromUp;
        }
    }

    private static void printLevel1(int[][] matrix, int row1, int col1, int row2, int col2, boolean fromUp) {
        if (fromUp) {
            while (row1 <= row2) {
                System.out.print(matrix[row1++][col1--] + " ");
            }
        } else {
            while (row2 >= row1) {
                System.out.print(matrix[row2--][col2++] + " ");
            }
        }
    }
}
