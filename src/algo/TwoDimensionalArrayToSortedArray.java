package algo;

import java.util.ArrayList;
import java.util.List;

// Ding interview
public class TwoDimensionalArrayToSortedArray {

    //评测题目: 无
    // 一个二维数组，乱序的，合并成一个有序数组并返回
    // 1,3,1,2
    // 2,0,5
    // 0,5,1,0,9
    // 解法1：转换成一维数组后冒泡（或其他排序）
    // Runtime: O(K * K), m为二维数组行，n为列
    // Space: O(K)
    public int[] flatSort_bubbleSort(int[][] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int[] result = flatArrays(array);
        //排序：冒泡
        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }

    // 解法2：转换为一维数据，再快排
    // Runtime: O(K logK)  -- K为二维数组元素个数
    // Space: O(K)
    public int[] flatSort_quickSort(int[][] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        //转换为一维数组
        int[] flatArray = flatArrays(array);
        //快排
        quickSort(flatArray, 0, flatArray.length - 1);
//        Arrays.sort(flatArray);

        return flatArray;
    }

    private int[] flatArrays(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            if (arr != null && arr.length != 0) {
                for (int i : arr) {
                    list.add(i);
                }
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (int i : list) {
            result[k++] = i;
        }
        return result;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    private int partition(int[] array, int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = array[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;    // increment index of smaller element
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
