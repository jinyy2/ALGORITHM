package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809_알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        int[] answer = new int[26];
        Arrays.fill(answer, -1);
        for (int i = 0; i < S.length; i++) {
            if (answer[S[i] - 'a'] == -1) {
                answer[S[i] - 'a'] = i;
            }
        }
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
