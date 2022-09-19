package com.algo.y2022.d0911;

import com.algo.util.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 零矩阵
 *
 * @author flynn
 * @date 2022/09/11
 */
public class ZeroMatrix {
    /*
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    示例 1：

    输入：
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    输出：
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]
    示例 2：

    输入：
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    输出：
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]

     */

    /**
     * 思路和算法
     *
     * 我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
     *
     * 具体地，我们首先遍历该数组一次，如果某个元素为 00，那么就将该元素所在的行和列所对应标记数组的位置置为 \text{true}true。最后我们再次遍历该数组，用标记数组更新原数组即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/zero-matrix-lcci/solution/ling-ju-zhen-by-leetcode-solution-7ogg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 暴力破解
     * @param matrix
     */
    public void setZeroesBaoLi(int[][] matrix) {
        List<Integer[]> zeroList = new LinkedList();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    Integer[] item = {i, j};
                    zeroList.add(item);
                }
            }
        }
        for (Integer[] arr : zeroList) {
            int i = arr[0];
            int j = arr[1];
            for (int k = 0; k < matrix.length; k++) {
                if (i == k) {
                    int[] row = matrix[k];
                    for (int l = 0; l < row.length; l++) {
                        if (row[l] != 0) {
                            row[l] = 0;
                        }
                    }
                }
                int[] row = matrix[k];
                if (row[j] != 0) {
                    row[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,3,0}
        };
        new ZeroMatrix().setZeroes(matrix1);
        PrintUtil.printMatrix(matrix1);
    }
}
