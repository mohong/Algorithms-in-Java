package _02_Sorting_Basic._05_Insertion_Sort;

import java.util.Arrays;

/**
 * 比较SelectionSort和InsertionSort两种排序算法的性能效率
 * 此时，插入排序比选择排序性能略低,因为每次交换(swap方法)的执行有三次操作，降低了性能
 * Created by mohon on 2017/10/14.
 */
public class Main {
    public static void main(String[] args) {
        int N = 500000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("_02_Sorting_Basic._05_Insertion_Sort.SelectionSort", arr1);
        SortTestHelper.testSort("_02_Sorting_Basic._05_Insertion_Sort.InsertionSort", arr2);
    }
}
