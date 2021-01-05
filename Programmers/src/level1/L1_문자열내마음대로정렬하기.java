package level1;

import java.util.Arrays;
import java.util.Comparator;

public class L1_문자열내마음대로정렬하기 {
	class Solution {
	    public String[] solution(String[] strings, int n) {
	        String[] answer = {};
	        Arrays.sort(strings,new Comparator<String>(){
	            @Override
	            public int compare(String s1, String s2){
	                char c1 = s1.charAt(n);
	                char c2 = s2.charAt(n);
	                if(c1==c2)return s1.compareTo(s2);
	                else return c1-c2;
	            }
	        });
	        return strings;
	    }
	}
}
