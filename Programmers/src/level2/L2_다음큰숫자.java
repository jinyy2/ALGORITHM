package level2;

public class L2_다음큰숫자 {

	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
	        int answer = 0;
	        int nextNum = n;
	        int nCountOne = 0;
	        String N = Integer.toBinaryString(n);
	        for(int i=0;i<N.length();i++){
	            if(N.charAt(i)=='1')nCountOne++;
	        }
	        
	        while(true){
	            String str = Integer.toBinaryString(++n);
	            int strCount = 0;
	            for(int i=0;i<str.length();i++){
	                if(str.charAt(i)=='1')strCount++;
	             }
	            if(nCountOne == strCount){
	                answer = n;
	                break;
	            }
	                

	            
	        }
	        return answer;
	    }
}
