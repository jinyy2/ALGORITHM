package weeklyChallenge;

import java.util.*;

public class Solution_모음사전 {
    public static void main(String[] args) {
        String word = "EIO";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        int[] num = {781, 156, 31, 6, 1};
        char[] ch = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            answer += map.get(ch[i]) * num[i];
        }

        return answer;
    }
}

