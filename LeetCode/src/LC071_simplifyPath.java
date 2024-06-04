import java.util.ArrayList;
import java.util.List;

public class LC071_simplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        //把目录名和操作目录的操作符号提取出来（“.”，“..”）
        String[] paths = path.split("/+", 0);
        System.out.println(paths.length);
        for (String path2 : paths) {
            System.out.println(path2);
        }
        // 通过数组来保存路径，通过添加或者删除来进入目录或者退出目录
        List<String> res = new ArrayList<>();
        res.add("/");
        for (String s : paths) {
            if (s.equals(""))
                continue;
            else  if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                // 判断是不是根目录
                if (res.size() == 1)
                    continue; // 根目录上去还是根目录
                else
                    res.remove(res.size() - 1);   // 返回上一级目录
            } else {
                // 进入下一级目录
                if (res.size() == 1)
                    res.add(s);   // 如果是根目录，就不加 /
                else
                    res.add("/" + s); // 如果不是根目录，就加/
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : res) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
