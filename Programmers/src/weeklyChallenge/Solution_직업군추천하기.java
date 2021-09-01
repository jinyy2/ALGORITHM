package weeklyChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_직업군추천하기 {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"JAVA", "JAVASCRIPT"};
        int[] preference = {7, 5};
        String result = "PORTAL";
        System.out.println(solution(table, languages, preference).equals(result));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        StringTokenizer st = null;
        String map[][] = new String[6][5];
        int max = Integer.MIN_VALUE;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(table[i]);
            for (int j = 0; j < map.length; j++) {
                map[j][i] = st.nextToken();
            }
            int sum = 0;
            for (int j = 1; j < map.length; j++) {
                loop:
                for (int l = 0; l < languages.length; l++) {
                    if (map[j][i].equals(languages[l])) {
                        sum += (6 - j) * preference[l];
                        break loop;
                    }
                }
            }
            if (max < sum) {
                list.clear();
                max = sum;
                list.add(map[0][i]);
            } else if (max == sum) {
                list.add(map[0][i]);
            }
        }

        Collections.sort(list);
        answer = list.get(0);
        return answer;
    }


}
