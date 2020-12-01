package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1924_2007년 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int cnt = d;
		int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		String[] weekday = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int i=0;i<m;i++) {
			cnt += month[i];
		}
		System.out.println(weekday[cnt%7]);
	
	}

}
