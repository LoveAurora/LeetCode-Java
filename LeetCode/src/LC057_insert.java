import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LC057_insert {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        System.out.println(Arrays.toString(insert(intervals, new int[]{2, 5})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        // 添加所有在新区间左侧且无交集的区间
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }
        // 有交集的区间，合并区间，更新 newInterval 到实际需要添加的区间
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval); // 添加合并后的区间

        // 添加所有在新区间右侧且无交集的区间
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }

        // 把list转换成数组
        int[][] ans = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
        // return list.toArray(new int[list.size()][2]);
    }
}
