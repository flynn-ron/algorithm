package com.algo.y2022.d0912;

import java.util.LinkedList;
import java.util.List;

/**
 * @author flynn
 * @date 2022/09/12
 */
public class md0912 {


    public static void main(String[] args) {

    }

    /*
    给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。

    示例1：
    输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[1,2,4,7,5,3,6,8,9]

    示例2：
    输入：mat = [[1,2],[3,4]]
    输出：[1,2,3,4]
     */

    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        return null;
    }

    private boolean isTopBorder(int[][] mat, int i, int j) {
        return i == 0;
    }

    private boolean isLeftBorder(int[][] mat, int i, int j) {
        return j == 0;
    }

    private boolean isRightBorder(int[][] mat, int i, int j) {
        return j == mat[0].length - 1;
    }

    private boolean isBottomBorder(int[][] mat, int i, int j) {
        return i == mat.length - 1;
    }
}
