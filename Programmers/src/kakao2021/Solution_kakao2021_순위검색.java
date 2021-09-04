package kakao2021;

import java.util.*;

public class Solution_kakao2021_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(solution(info, query));
    }

    public static int[] solution(String[] info, String[] query) {

        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> scoreList = new ArrayList<>();
        map.put("-", 0);
        map.put("cpp", 1);
        map.put("java", 2);
        map.put("python", 3);
        map.put("backend", 1);
        map.put("frontend", 2);
        map.put("junior", 1);
        map.put("senior", 2);
        map.put("chicken", 1);
        map.put("pizza", 2);
        for (int i = 0; i < 4 * 3 * 3 * 3; ++i) {
            scoreList.add(new ArrayList<>());
        }
        for (int i = 0; i < info.length; ++i) {
            String[] str = info[i].split(" ");
            int[] index = {map.get(str[0]) * 3 * 3 * 3,
                    map.get(str[1]) * 3 * 3,
                    map.get(str[2]) * 3,
                    map.get(str[3])};
            int score = Integer.parseInt(str[4]);
            for (int j = 0; j < (1 << 4); ++j) {
                int idx = 0;
                for (int k = 0; k < 4; ++k) {
                    if ((j & (1 << k)) != 0) {
                        idx += index[k];
                    }
                }
                scoreList.get(idx).add(score);
            }
        }
        for (int i = 0; i < 4 * 3 * 3 * 3; ++i) {
            Collections.sort(scoreList.get(i));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            String[] str = query[i].split(" ");
            int idx = map.get(str[0]) * 3 * 3 * 3 +
                    map.get(str[2]) * 3 * 3 +
                    map.get(str[4]) * 3 +
                    map.get(str[6]);
            int score = Integer.parseInt(str[7]);
            int ret = Collections.binarySearch(scoreList.get(idx), score);
            if (ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; --j) {
                    if (scoreList.get(idx).get(j) == score) {
                        ret = j;
                    } else {
                        break;
                    }

                }
            }
            answer[i] = scoreList.get(idx).size() - ret;
        }
        return answer;
    }

}
