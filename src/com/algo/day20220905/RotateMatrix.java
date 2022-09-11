package com.algo.day20220905;

/**
 * @author flynn
 * @date 2022/09/11
 */
public class RotateMatrix {

        /*
题目：
给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
不占用额外内存空间能否做到？

     示例1：
     给定 matrix =
     [
         [1,2,3],
         [4,5,6],
         [7,8,9]
     ],
     原地旋转输入矩阵，使其变为:
     [
         [7,4,1],
         [8,5,2],
         [9,6,3]
     ]

     示例2：
     给定 matrix =
     [
         [ 5, 1, 9,11],
         [ 2, 4, 8,10],
         [13, 3, 6, 7],
         [15,14,12,16]
     ],

     原地旋转输入矩阵，使其变为:
     [
         [15,13, 2, 5],
         [14, 3, 4, 1],
         [12, 6, 8, 9],
         [16, 7,10,11]
     ]
     */

    /**
     * 思路(评论区学来的)：
     * 顺时针旋转90°：先水平翻转，再对角线翻转
     * 逆时针旋转90°：先对角线翻转，再水平翻转
     * <p>
     * 先手工演算，验证一下这结论，再按思路来写就好写了
     */
    public void rotate(int[][] matrix) {
        // 1、水平翻转；
        int iStart = 0;
        int iEnd = matrix.length - 1;
        while (iStart < iEnd) {
            swapRow(matrix, iStart, iEnd);
            iStart++;
            iEnd--;
        }
        // 2、对角线翻转(下标i=j为对角线)
        for (int i = 0; i < matrix.length; i++) {
            int[] rowArr = matrix[i];
            for (int j = 0; j < rowArr.length; j++) {
                if (j >= i) {
                    break;
                }
                swapItem(matrix, i, j);
            }
        }
    }

    // 行交换
    public void swapRow(int[][] matrix, int r1, int r2) {
        int[] tmp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = tmp;
    }

    // 对角线交换
    public void swapItem(int[][] matrix, int rowIndex, int colIndx) {
        if (rowIndex == colIndx) {
            return;
        }
        int[] row1 = matrix[rowIndex];
        int[] row2 = matrix[colIndx];
        int tmp = row1[colIndx];
        row1[colIndx] = row2[rowIndex];
        row2[rowIndex] = tmp;
    }

}

class TestRotateMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateMatrix instance = new RotateMatrix();
        instance.rotate(matrix1);
        instance.rotate(matrix2);

        printMatrix(matrix1);
        printMatrix(matrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}