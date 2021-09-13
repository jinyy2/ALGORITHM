package weeklyChallenge;

import java.util.*;

public class Solution_복서정렬하기 {
    public static void main(String[] args) {
        int[] weights = {60,70,60};
        String[] head2head = {"NNN","NNN","NNN"};
        System.out.println(Arrays.toString(solution(weights, head2head)));
    }

    static class Player {
        int id;
        int weight;
        int winGame;
        int winWeight;
        int totalGame;

        public Player(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        List<Player> list = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            list.add(new Player(i + 1, weights[i]));
        }

        for (int i = 0; i < head2head.length; i++) {
            char[] matchResult = head2head[i].toCharArray();

            for (int j = 0; j < matchResult.length; j++) {
                if (i == j) continue; // 본인
                if (matchResult[j] != 'N') list.get(i).totalGame++;
                if (matchResult[j] == 'W') {
                    list.get(i).winGame++;
                    if (list.get(i).weight < list.get(j).weight) {
                        list.get(i).winWeight++;
                    }
                }
            }
        }

        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                double aWinRate = 0.0;
                double bWinRate = 0.0;
                if (o1.totalGame > 0) {
                    aWinRate = (double) o1.winGame / o1.totalGame * 100;
                }
                if (o2.totalGame > 0) {
                    bWinRate = (double) o2.winGame / o2.totalGame * 100;
                }
                if (aWinRate != bWinRate) {
                    return aWinRate - bWinRate < 0 ? 1 : -1;
                } else if (o1.winWeight != o2.winWeight) {
                    return -(o1.winWeight - o2.winWeight);
                } else if (o1.weight != o2.weight) {
                    return -(o1.weight - o2.weight);
                } else {
                    return o1.id - o2.id;
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).id;
        }
        return answer;
    }

}
