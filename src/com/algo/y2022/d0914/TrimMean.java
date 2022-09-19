package com.algo.y2022.d0914;

import java.util.Arrays;

/**
 * @author flynn
 * @date 2022/09/14
 */
public class TrimMean {

    public static void main(String[] args) {
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        double result = new TrimMean().trimMean(arr);
        System.out.println(result);
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        int start = (int) (arr.length * 0.05);
        int end = (int) (arr.length * 0.95);
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        if (end - start == 0) {
            return -1;
        }
        return sum / (end - start);
    }


}
