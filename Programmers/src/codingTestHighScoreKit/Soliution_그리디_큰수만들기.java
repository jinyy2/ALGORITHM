package codingTestHighScoreKit;

public class Soliution_그리디_큰수만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number,k));
	}

	public static String solution(String number, int k) {
	        String answer = "";
	        char[] ch = number.toCharArray();
	        boolean[] visited = new boolean[number.length()];
	        StringBuilder sb = new StringBuilder();
	        int index = 0;

	        for(int i=0;i<number.length()-k;i++){
	            int max = Integer.MIN_VALUE;
	            
	            if(visited[index]) index++;
	            for(int j=index;j<=k+i;j++){
	                int n = ch[j]-'0';
	                
	                if(max<n){
	                    max = n;
	                    index = j;
	                    if(n==9) break;
	                }
	            }
	            visited[index] = true;
	            
	            sb.append(max);
	        }
	        
	        answer = sb.toString();
	        return answer;
	    }
}
