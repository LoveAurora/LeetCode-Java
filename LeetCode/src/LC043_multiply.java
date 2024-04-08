public class LC043_multiply {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        // 乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
        // num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x", "xy" 的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。

        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int temp;
        StringBuilder stringBuilder = new StringBuilder();
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';// char转int
                temp = (n1 * n2 + result[i + j + 1]); // 第i位数和第j位数相乘的结果的最低位为i+j+1位，最高位为i+j ，例如 3 x 6，3和6为第0位，相乘为18，1为第一位，8为第二位
                result[i + j + 1] = temp % 10; //更新第i位数和第j位数相乘的低位结果
                result[i + j] += temp / 10;//更新第i位数和第j位数相乘的高位结果
            }
        }
        int start = 0;
        if (result[0] == 0) {
            start = 1;
        }
        for (int i = start; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();

    }
}
