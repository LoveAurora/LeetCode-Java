public class LC008_myAtoi {
    public static void main(String[] args) {
        LC008_myAtoi test = new LC008_myAtoi();
        System.out.println(test.myAtoi("+1"));
    }

    // 第一次的做法
    public int myAtoi(String s) {
        // 首先，我们去除字符串的前后空格
        s = s.trim();

        // 如果字符串为空，我们直接返回0
        if (s.isEmpty()) {
            return 0;
        }

        // 初始化标志位为1，表示默认为正数
        int flag = 1;

        // 初始化开始和结束的索引为-1
        int start = -1;
        int end = -1;

        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 如果字符为'-'，则表示这是一个负数
            if (s.charAt(i) == '-') {
                // 如果'-'后面还有字符，并且这个字符是数字，我们将标志位设为-1，并跳过当前循环
                if (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    flag = -1;
                    continue;
                } else {
                    // 如果'-'后面没有字符，或者字符不是数字，我们直接返回0
                    return 0;
                }
            }

            // 如果字符为'+'，我们跳过当前循环
            if (s.charAt(i) == '+') {
                if (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)))
                    continue;
                else
                    // 如果'+'后面没有字符，或者字符不是数字，我们直接返回0
                    return 0;
            }

            // 如果字符为' '，我们跳过当前循环
            if (s.charAt(i) == ' ') {
                continue;
            }

            // 如果字符不是数字，我们直接返回0
            if (!Character.isDigit(s.charAt(i))) {
                return 0;
            }

            // 如果字符是数字，我们记录开始和结束的索引
            if (Character.isDigit(s.charAt(i))) {
                start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                // 指向最后一个数字的位置
                end = i - 1;
                break;
            }
        }

        // 尝试将字符串转换为整数
        try {
            // 如果转换成功，我们返回转换后的整数
            return Integer.parseInt(s.substring(start, end + 1)) * flag;
        } catch (NumberFormatException e) {
            // 如果转换失败（例如，字符串表示的整数超过了Integer的最大值或最小值），我们返回Integer的最大值或最小值
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    public int myAtoi0(String str) {
        if (str.isEmpty()) return 0;
        int index = 0, n = str.length(), sign = 1, res = 0;
        // 处理前置空格
        while (index < n && str.charAt(index) == ' ') {
            ++index;
        }
        // 处理符号
        if (index < n && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }
        // 处理数字
        while (index < n && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            // 判断是否溢出
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++index;
        }
        return res * sign;
    }
}
