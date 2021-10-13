package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);

            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();
            int lIdx = 0;
            int rIdx = 0;
            boolean flag = false;
            while (lIdx < s.length && rIdx < t.length) {
                if (s[lIdx] == t[rIdx]) {
                    lIdx++;
                    rIdx++;
                } else {
                    rIdx++;
                }
                if (lIdx == s.length) {
                    flag = true;
                }
            }
            if (flag) {
                sb.append("Yes").append("\n");
            } else sb.append("No").append("\n");
        }
        System.out.println(sb);
    }
}
