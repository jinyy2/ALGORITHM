package codingTestHighScoreKit;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_DFSBFS_여행경로 {

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
		solution(tickets);
	}
	static boolean[] visited;
    static String[][] map;
    static ArrayList<String> list;
    static String[] answer;
    static boolean flag;
    
    static class Ticket implements Comparable<Ticket>{
        String end;
        int idx;
        public Ticket(String end, int idx){
            this.end = end;
            this.idx = idx;
            
        }
        @Override
            public int compareTo(Ticket t){
                return this.end.compareTo(t.end);
            }
    }
    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        map = tickets;
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        list.add("ICN");
        dfs(list.get(0),0,0);
        
        
        
        return answer;
    }
    public static void dfs(String start, int cnt,int exIdx){
    	System.out.println(start+" "+cnt);
        if(flag) return;
        if(cnt == map.length){
            for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
              for(String i: list){
                  System.out.print(i + " ");
              }
            flag = true;
            return;
        }
        ArrayList<Ticket> tList = new ArrayList<>();
        for(int i=0;i<map.length;i++){
         if(!visited[i]&&map[i][0].equals(start)){
        	 tList.add(new Ticket(map[i][1],i));
            }
        }
        if(tList.size()==0) {
        	list.remove(list.size()-1);
        	visited[exIdx] = false;
        	cnt--;
        }
        Collections.sort(tList);
        Ticket t = tList.get(0);
        tList.remove(0);
        visited[t.idx] = true;
        list.add(t.end);
        dfs(t.end, cnt+1,t.idx);
        visited[t.idx] = false;
        list.remove(list.size()-1);
        
    }
}
