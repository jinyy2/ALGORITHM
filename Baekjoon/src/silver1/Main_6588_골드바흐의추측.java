package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] num = new boolean[1000001];
        for (int i = 2; i <= Math.sqrt(num.length); i++) {
            if (num[i]) continue;
            for (int j = i + i; j < num.length; j += i) {
                num[j] = true;
            }
        }
        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            if (input.equals("0")) break;
            int number = Integer.parseInt(input);

            boolean flag = false;
            for (int i = 2; i <= number / 2; i++) {
                if (!num[i] && !num[number - i]) {
                    flag = true;
                    sb.append(number).append(" = ").append(i).append(" + ").append(number - i).append("\n");
                    break;
                }
            }
            if (!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb.toString());

    }
}
