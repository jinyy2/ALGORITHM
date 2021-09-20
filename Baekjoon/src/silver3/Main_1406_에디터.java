package silver3;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stcakLeft = new Stack<>();
        Stack<Character> stcakRight = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stcakLeft.add(str.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c == 'L') {
                if (!stcakLeft.isEmpty()) stcakRight.add(stcakLeft.pop());
            } else if (c == 'D') {
                if (!stcakRight.isEmpty()) stcakLeft.add(stcakRight.pop());
            } else if (c == 'B') {
                if (!stcakLeft.isEmpty()) stcakLeft.pop();
            } else {
                char addChar = st.nextToken().charAt(0);
                stcakLeft.add(addChar);

            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stcakLeft.isEmpty()) {
            sb.append(stcakLeft.pop());
        }
        sb.reverse();
        while (!stcakRight.isEmpty()) {
            sb.append(stcakRight.pop());
        }
        System.out.println(sb.toString());
    }
}
