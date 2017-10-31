package _06_Union_Find._03_Quick_Union;

/**
 * 并查集
 * Created by mohon on 2017/10/31.
 */
public class UnionFind1 {
    // 我们的第一版Union-Find本质就是一个数组
    private int[] id;
    private int count;

    public UnionFind1(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    // 查找过程，查找元素p所对应的集合编号
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }
    // 查看元素p和元素q是否属于同一集合
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    // 合并元素p和元素q所属的集合
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        // 合并过程需要遍历一遍所有元素，将两个元素的所属集合编号合并
        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
