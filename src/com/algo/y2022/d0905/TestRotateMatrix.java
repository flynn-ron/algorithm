package com.algo.y2022.d0905;

import com.algo.util.PrintUtil;

/**
 * @author flynn
 * @date 2022/09/05
 */
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
        // 旋转
        RotateMatrix instance = new RotateMatrix();
        instance.rotate(matrix1);
        instance.rotate(matrix2);

        // 打印
        PrintUtil.printMatrix(matrix1);
        PrintUtil.printMatrix(matrix2);
    }

}
