package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, ArrayList<String>> map = new HashMap<>();
            StringTokenizer st = null;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken();
                String clothes = st.nextToken();
                if (!map.containsKey(clothes)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(clothName);
                    map.put(clothes, list);
                } else {
                    map.get(clothes).add(clothName);
                }
            }
            int count = 1;
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                count *= entry.getValue().size() + 1;
            }
            System.out.println(count - 1);
        }
    }
}
