package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12871_무한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        sbS.append(s);
        sbT.append(t);

        while (true) {
            if (sbS.toString().length() > sbT.toString().length()) {
                sbT.append(t);
            } else if (sbS.toString().length() < sbT.toString().length()) {
                sbS.append(s);
            } else {
                if (sbS.toString().equals(sbT.toString())) {
                    System.out.println("1");
                    break;
                } else {
                    System.out.println("0");
                    break;
                }
            }
        }
    }
}
