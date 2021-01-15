package codingTestHighScoreKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution_해시_베스트앨범 {
	static class Song implements Comparable<Song>{
		int idx;
		int count;
		String genre;
		
		public Song(int idx, int count, String genre) {
			this.idx = idx;
			this.count = count;
			this.genre = genre;
		}
		
		@Override
		public int compareTo(Song o) {
			if(this.count==o.count) {
				return this.idx-o.idx;
			} else {
				return -(this.count-o.count);
			}
		}
		
		@Override
		public String toString() {
			return this.genre+" "+this.count+" "+this.idx;
			
		}
	}
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] temp = solution(genres,plays);
		System.out.println(Arrays.toString(temp));
	}
	
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        ArrayList<Song> list = new ArrayList<Song>();
        ArrayList<Integer> result =new ArrayList<>();
        HashMap<String, Integer> hs = new HashMap<>();
        HashMap<String, Integer> gCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
			list.add(new Song(i,plays[i],genres[i]));
			if(!hs.containsKey(genres[i])) hs.put(genres[i],plays[i]);
        	else hs.put(genres[i],hs.get(genres[i])+plays[i]);
		}
        
        
        for(Song s : list) {
        	System.out.println(s.toString());}
        System.out.println();
        Collections.sort(list, new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				if(o1.genre.equals(o2.genre)) {
					o1.compareTo(o2);
				} else {
					return -(hs.get(o1.genre)-hs.get(o2.genre));
				}
				return 0;
			}
        
        });
        
        for(Song s : list) {
        	System.out.println(s.toString());
        	if(!gCnt.containsKey(s.genre)) {
        		gCnt.put(s.genre, 1);
        		result.add(s.idx);
        	} else {
        		if(gCnt.get(s.genre)<2) {
        			gCnt.put(s.genre, gCnt.get(s.genre)+1);
        			result.add(s.idx);
        		};
        	}
        }
        answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }

}
