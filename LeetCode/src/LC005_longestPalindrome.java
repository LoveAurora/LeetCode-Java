public class LC005_longestPalindrome {
    public static void main(String[] args) {
        LC005_longestPalindrome test = new LC005_longestPalindrome();
        String s = "babad";
        System.out.println(test.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            // j = 0 初始的 left = right,中心点只有一个 ; j = 1时 left = i,right = i+1,中心点有两个
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                left++;
                right--;
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
