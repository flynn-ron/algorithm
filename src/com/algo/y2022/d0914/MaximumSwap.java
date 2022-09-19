package com.algo.y2022.d0914;

import java.util.Arrays;

/**
 * @author flynn
 * @date 2022/09/14
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().myMaximumSwap(98368));
        System.out.println(new MaximumSwap().officialMaximumSwap(126373));
        System.out.println(new MaximumSwap().maxSwap(126373));
    }

    public int maxSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int length = arr.length;
        int maxId = length - 1;
        // 比右侧最大值小的数
        int lessIndex = -1;
        // 最大值的index
        int maxIndex = -1;

        for (int i = maxId - 1; i >= 0; i--) {
            if (arr[i] > arr[maxId]) {
                // 有更大的值, 下标改变
                maxId = i;
            } else if (arr[i] < arr[maxId]) {
                //
                lessIndex = i;
                maxIndex = maxId;
            } else {
                // 相等，不处理
            }
        }
        if (lessIndex >= 0) {
            swap(arr, lessIndex, maxIndex);
            return Integer.parseInt(new String(arr));
        } else {
            return num;
        }



    }

    public int officialMaximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public int myMaximumSwap(int num) {
        char[] sourceArr = (num + "").toCharArray();
        char[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        Arrays.sort(arr);
        for (int i = 0; i < sourceArr.length; i++) {
            char maxItem = arr[sourceArr.length - i - 1];
            if (sourceArr[i] < maxItem) {
                // 交换
                swap(sourceArr, i, maxItem);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(sourceArr));
    }

    private void swap(char[] sourceArr, int index, char value) {
        for (int i = sourceArr.length - 1; i >= 0; i--) {
            if (sourceArr[i] == value) {
                char temp = sourceArr[index];
                sourceArr[index] = value;
                sourceArr[i] = temp;
            }
        }
    }

}
