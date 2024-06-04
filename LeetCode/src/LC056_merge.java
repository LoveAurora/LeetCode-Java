import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC056_merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        LC056_merge lc056_merge = new LC056_merge();
        int[][] result = lc056_merge.merge(intervals);
        for (int[] subArray : result) {
            System.out.println(Arrays.toString(subArray));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][2];
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][1] < intervals[i + 1][1]) {
                intervals[i + 1][0] = intervals[i][0];
            } else if (intervals[i][1] >= intervals[i + 1][1]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = intervals[i][1];
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                result.add(tempList);
            }
        }
        List<Integer> tempList = new ArrayList<>();
        tempList.add(intervals[len - 1][0]);
        tempList.add(intervals[len - 1][1]);
        result.add(tempList);

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i][0] = result.get(i).get(0);
            answer[i][1] = result.get(i).get(1);
        }
        return answer;
    }


}
