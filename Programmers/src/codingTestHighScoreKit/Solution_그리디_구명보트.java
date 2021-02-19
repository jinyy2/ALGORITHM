package codingTestHighScoreKit;

import java.util.*;

public class Solution_그리디_구명보트 {

	public static void main(String[] args) {
		int[] people = {70,50,80,50};
		int limit = 100;
		System.out.println(solution(people,limit));
	}

	public static int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int i=0; 
	        int j=people.length-1;
	        while(i<=j){
	            if(i==j){
	                answer++;
	                break;
	                }
	            if(people[i]+people[j]<=limit){
	                ++answer;
	                ++i;
	                --j;
	            } else{
	                --j;
	                answer++;
	                
	            }
	            
	        }
	            
	            
	        return answer;
	    }
}

