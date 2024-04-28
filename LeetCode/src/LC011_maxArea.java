public class LC011_maxArea {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        /*
        若向内移动短板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积可能增大 。
        若向内移动长板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 不变或变小，因此下个水槽的面积一定变小 。
         */
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return maxArea;
    }
}
