public class LC070_climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;

    }
}
