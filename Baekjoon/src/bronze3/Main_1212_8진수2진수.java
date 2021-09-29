package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1212_8진수2진수 {
    public static void main(String[] args) throws IOException {
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            sb.append(arr[ch[i] - '0']);
        }
        while (sb.toString().charAt(0) == '0') {
            if (sb.toString().length() == 1 && sb.toString().equals("0")) break;
            sb.deleteCharAt(0);
        }
        System.out.println(sb.toString());
    }
}
