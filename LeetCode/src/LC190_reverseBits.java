public class LC190_reverseBits {
    public int reverseBits(int n) {
        // 初始化反转结果为0
        int rev = 0;
        // 遍历输入整数的每一位
        for (int i = 0; i < 32 && n != 0; ++i) {
            // 使用位运算将n的最后一位添加到rev的对应位置
            rev |= (n & 1) << (31 - i);
            // 将n右移一位
            n >>>= 1;
        }
        // 返回反转后的结果
        return rev;
    }
}
