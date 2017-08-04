package leetcode;

import java.util.*;

/**
 * Created by mohon on 2017/8/4.
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!record.containsKey(nums1[i])) {
                record.put(nums1[i], 1);
            } else {
                record.put(nums1[i], record.get(nums1[i])+1);
            }
        }
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (record.containsKey(nums2[i]) && record.get(nums2[i]) > 0) {
                resultList.add(nums2[i]);
                record.put(nums2[i], record.get(nums2[i])-1);
                if (record.get(nums2[i]) == 0) {
                    record.remove(nums2[i]);
                }
            }
        }
        int i = 0;
        int[] result = new int[resultList.size()];
        Iterator<Integer> it = resultList.iterator();
        while (it.hasNext()) {
            result[i++] = it.next();
        }
        return result;
    }
}
