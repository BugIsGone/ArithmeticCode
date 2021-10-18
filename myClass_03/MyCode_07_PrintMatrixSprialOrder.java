package myClass_03;

/**
 * @author shapemind
 * @create 2021-10-18 8:36
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
public class MyCode_07_PrintMatrixSprialOrder {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        sprialPrintOrder(matrix);
    }

    public static void sprialPrintOrder(int[][] matrix) {
        int topR = 0;
        int topC = 0;
        int downC = matrix[0].length - 1;
        int downR = matrix.length - 1;
        while (topR <= downR && topC <= downC) {
            printEdge(matrix, topR++, topC++, downR--, downC--);
        }
    }

    public static void printEdge(int[][] matrix, int topR, int topC, int downR, int downC) {
        if (topR == downR) {
            for (int i = topC; i <= downC; i++) {
                System.out.print(matrix[topR][i] + " ");
            }
        } else if (topC == downC) {
            for (int i = topR; i <= downR; i++) {
                System.out.print(matrix[i][topC] + " ");
            }
        } else {
            int copyTopR = topR;
            int copyTopC = topC;
            while (copyTopC < downC) {
                System.out.print(matrix[topR][copyTopC++] + " ");
                //System.out.print(matrix[copyTopR][copyTopC++] + " ");
            }
            while (copyTopR < downR) {
                System.out.print(matrix[copyTopR++][copyTopC] + " ");
            }
            while (copyTopC > topC) {
                System.out.print(matrix[copyTopR][copyTopC--] + " ");
            }
            while (copyTopR > topR) {
                System.out.print(matrix[copyTopR--][copyTopC] + " ");
            }
        }
    }
}
