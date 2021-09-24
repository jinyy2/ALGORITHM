package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11655_ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if ('a' <= ch[i] & ch[i] <= 'z') {
                if('z'<(char)((int)ch[i]+13)) ch[i]= (char)((int)ch[i]+13-26);
                else ch[i]=(char)((int)ch[i]+13);
            } else if ('A' <= ch[i] & ch[i] <= 'Z') {
                if('Z'<(char)((int)ch[i]+13)) ch[i]= (char)((int)ch[i]+13-26);
                else ch[i]=(char)((int)ch[i]+13);
            }
        }
        for (char c : ch) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
