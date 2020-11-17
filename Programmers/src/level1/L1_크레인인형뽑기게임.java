package level1;

import java.util.*;

public class L1_크레인인형뽑기게임 {
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        int N = board.length;
	        Stack<Integer> stack = new Stack<>();
	        for(int m = 0;m<moves.length;m++){
	            
	            for(int i=0;i<N;i++){
	                if(board[i][moves[m]-1]==0)continue;
	                System.out.print(board[i][moves[m]-1]);
	                if(!stack.empty() && board[i][moves[m]-1] == stack.peek()){
	                    stack.pop();
	                    answer += 2; 
	                }else{
	                stack.push(board[i][moves[m]-1]);    
	                }
	                board[i][moves[m]-1] = 0; // 크레인 작동 후 인형 없음
	                break;
	                
	            }
	        }
	        
	        return answer;
	    }
	}
}
