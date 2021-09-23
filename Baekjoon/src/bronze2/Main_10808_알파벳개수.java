package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        for (int i = 0; i < S.length; i++) {
            alphabet[S[i] - 'a']++;
        }
        for (int i : alphabet) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
