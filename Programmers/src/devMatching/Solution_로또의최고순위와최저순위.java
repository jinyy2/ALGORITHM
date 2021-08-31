package devMatching;

import java.util.Arrays;

public class Solution_로또의최고순위와최저순위 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int corCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    corCnt++;
                    break;
                }
            }
        }
        answer[0] = 7 - corCnt - zeroCnt;
        answer[1] = 7 - corCnt;
        if (answer[0] == 7) answer[0] = 6;
        if (answer[1] == 7) answer[1] = 6;

        return answer;
    }
}
