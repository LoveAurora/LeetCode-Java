import java.util.HashMap;
import java.util.Map;

public class LC003_lengthOfLongestSubstring {
    public static void main(String[] args) {
        // 创建一个测试实例
        LC003_lengthOfLongestSubstring test = new LC003_lengthOfLongestSubstring();
        // 测试并打印结果
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 创建一个哈希映射来存储字符和其出现的位置
        Map<Character, Integer> map = new HashMap<>();
        // 初始化最大长度为0
        int max = 0;
        // 初始化左右指针
        int left = 0, right = 0;
        // 当右指针没有到达字符串的末尾时，进行循环
        while (right < s.length()) {
            // 如果当前字符已经在哈希映射中，移除左指针指向的字符，并将左指针向右移动一位
            if (map.containsKey(s.charAt(right))) {
                map.remove(s.charAt(left));
                left++;
            } else {
                // 如果当前字符不在哈希映射中，将其添加到哈希映射，并将右指针向右移动一位
                map.put(s.charAt(right), 1);
                right++;
                // 更新最大长度
                max = Math.max(max, right - left);
            }
        }
        // 返回最大长度
        return max;
    }

    public int lengthOfLongestSubstring0(String s) {
        if (s.isEmpty())
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}