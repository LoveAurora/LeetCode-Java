public class LC058_lengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
//        String[] result = s.split(" ");
//        int len = result.length;
//        return result[len - 1].length();
        s = s.trim();
        int len = s.lastIndexOf(" ");
        return s.length() - len;
    }
}
