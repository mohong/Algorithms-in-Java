package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by mohon on 2017/8/4.
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set record = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        Set resultSet = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (record.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int i = 0;
        int[] result = new int[resultSet.size()];
        Iterator it = resultSet.iterator();
        while (it.hasNext()) {
            result[i++] = (int) it.next();
        }
        return  result;
    }
}
