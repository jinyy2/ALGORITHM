package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10824_네수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        System.out.println(Long.parseLong("" + num[0] + num[1]) + Long.parseLong("" + num[2] + num[3]));
    }
}