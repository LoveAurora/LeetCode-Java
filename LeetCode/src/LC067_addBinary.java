import java.math.BigInteger;

public class LC067_addBinary {
    public static void main(String[] args) {
        // 测试数据
        String a = "11";
        String b = "1";
        // 打印结果
        System.out.println(addBinary(a, b));
    }

    /**
     * 二进制字符串相加
     * @param a 二进制字符串a
     * @param b 二进制字符串b
     * @return 相加后的结果
     */
    public static String addBinary(String a, String b) {
        // 初始化字符串长度和进位
        int m = a.length();
        int n = b.length();
        // 如果a为空，返回b
        if (m==0) return b;
        // 如果b为空，返回a
        if (n==0) return a;
        // 计算最小长度
        int len = Math.min(m, n);
        int carry = 0;
        int sum = 0;
        // 创建字符串缓冲区
        StringBuffer sba = new StringBuffer(a);
        StringBuffer sbb = new StringBuffer(b);
        StringBuffer res = new StringBuffer();
        // 反转字符串
        sba.reverse();
        sbb.reverse();
        // 遍历字符串，计算和
        for (int i = 0; i < len; i++) {
            sum = (sba.charAt(i) - '0') + (sbb.charAt(i) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        // 如果a的长度大于b的长度，处理a的剩余字符
        if (m > n) {
            for (int i = len; i < m; i++) {
                sum = (sba.charAt(i) - '0') + carry;
                res.append(sum % 2);
                carry = sum / 2;
            }
        } else {
            // 如果b的长度大于a的长度，处理b的剩余字符
            for (int i = len; i < n; i++) {
                sum = (sbb.charAt(i) - '0') + carry;
                res.append(sum % 2);
                carry = sum / 2;
            }
        }
        // 如果最后还有进位，添加到结果字符串
        if (carry == 1) {
            res.append(1);
        }
        // 反转结果字符串并返回
        return res.reverse().toString();
    }
}