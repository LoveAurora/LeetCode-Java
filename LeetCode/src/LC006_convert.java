public class LC006_convert {
    public static void main(String[] args) {
        LC006_convert c = new LC006_convert();
        System.out.println(c.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        StringBuffer[] stringBuffer = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuffer[i] = new StringBuffer();
        }
        int i = 0, temp = 2 * numRows - 2;
        for (char c : s.toCharArray()) {
            if (i % temp == 0) i = 0;
            if (i < numRows)
                stringBuffer[i].append(c);
            else
                stringBuffer[temp - i].append(c);
            i++;
        }
        StringBuffer str = new StringBuffer();
        for (int j = 0; j < numRows; j++) {
            str.append(stringBuffer[j]);
        }
        return str.toString();
    }
}