package codingTestHighScoreKit;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_완전탐색_모의고사 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(input)));
		
	}
	public static int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[4];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<answers.length;i++){
            if(person1[i%person1.length]==answers[i]) score[1]++;
            if(person2[i%person2.length]==answers[i]) score[2]++;
            if(person3[i%person3.length]==answers[i]) score[3]++;
        }
        for(int i=1;i<score.length;i++){
            max = Math.max(max,score[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<score.length;i++){
           if(max==score[i]){
               list.add(i);
           }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
