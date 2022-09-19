package com.algo.util;

/**
 * @author flynn
 * @date 2022/09/11
 */
public class PrintUtil {
    /**
     * 打印矩阵
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] intArr : matrix) {
            for (int ints : intArr) {
                System.out.print(ints + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int ints : array) {
            System.out.println(ints + ",");
        }
    }

}
