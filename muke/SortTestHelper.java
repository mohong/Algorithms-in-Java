package muke;

import java.util.Random;

/**
 * 排序测试用例
 * Created by mohon on 2017/4/16.
 */
public class SortTestHelper {
    /**
     * 生成有n个元素的随机数组，每个元素的随机范围为[rangL, rangR]
     * @param n  生成的元素的个数
     * @param rangeL    左取值，闭合
     * @param rangR     右取值，闭合
     * @return  生成的随机数组
     */
    public int[] generateRandomArray(int n, int rangeL, int rangR) {
        assert rangeL < rangR;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /**
     * 遍历打印数组
     * @param arr 需要打印的数组
     * @param n 数组的长度
     */
    public void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public void testSort(String sortName, Void sort, int[] arr, int n) {
        long start = System.currentTimeMillis();
        float time = (System.currentTimeMillis()-start)/1000f;
    }
}
