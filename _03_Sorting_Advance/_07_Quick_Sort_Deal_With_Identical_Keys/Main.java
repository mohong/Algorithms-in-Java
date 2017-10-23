package _03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys;

import _03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.SortTestHelper;

import java.util.Arrays;

/**
 * Created by mohon on 2017/10/17.
 */
public class Main {
    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 1000000);
        Integer[] arr2 = Arrays.copyOf(arr1, N);
        Integer[] arr3 = Arrays.copyOf(arr1, N);

        SortTestHelper.testSort("_03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.MergeSort", arr1);
        SortTestHelper.testSort("_03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.InsertionSort", arr2);
        SortTestHelper.testSort("_03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.QuickSort2Ways", arr3);
    }
}
