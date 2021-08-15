package weeklyChallenge;

public class Solution_상호평가 {
    public static void main(String[] args) {
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        String answer = "";
        int n = scores.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            double avg = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                min = Math.min(min, scores[j][i]);
                max = Math.max(max, scores[j][i]);
                sum += scores[j][i];
            }

            if (scores[i][i] > max || scores[i][i] < min) {
                avg = (double) sum / (n - 1);
            } else {

                avg = (double) (sum + scores[i][i]) / n;
            }
            sb.append(getGrade(avg));

        }
        answer = sb.toString();
        return answer;
    }

    public static String getGrade(double avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
