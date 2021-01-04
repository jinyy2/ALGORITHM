package level1;

public class L1_콜라츠추측 {
	class Solution {
	    public int solution(int num) {
	        int answer = 0;
	        int count = 0;
	        boolean flag = true;
	        while(flag){
	            if(num == 1){
	                return count;
	            }
	            else if(count==500){
	                return -1;
	            }
	            if(num%2==0){
	                num /= 2;
	            } else if(num%2==1){
	                num = num * 3 + 1;
	            }
	            count++;
	            
	        }
	        return answer;
	    }
	}
}
