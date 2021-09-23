package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10820_문자열분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null) {
            char[] ch = str.toCharArray();
            int[] count = new int[4];
            for (int i = 0; i < ch.length; i++) {
                if ('a' <= ch[i] && ch[i] <= 'z') count[0]++;
                else if ('A' <= ch[i] && ch[i] <= 'Z') count[1]++;
                else if ('0' <= ch[i] && ch[i] <= '9') count[2]++;
                else count[3]++;
            }
            for (int i : count) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
