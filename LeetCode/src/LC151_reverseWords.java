public class LC151_reverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
