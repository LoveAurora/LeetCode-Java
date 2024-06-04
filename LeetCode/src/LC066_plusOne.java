import java.util.Arrays;

public class LC066_plusOne {
    public static void main(String[] args) {
        int[] n = {8, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(n)));
    }

    public static int[] plusOne(int[] digits) {
        int temp;
        int carry = 0;
        int len = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                temp = digits[i] + carry + 1;
            } else {
                temp = digits[i] + carry;
            }
            carry = 0;
            if (temp < 10) {
                digits[i] = temp;
                break;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }

        if (carry == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        } else return digits;


    }
}
