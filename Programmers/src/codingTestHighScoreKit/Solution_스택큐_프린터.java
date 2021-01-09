package codingTestHighScoreKit;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_스택큐_프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		
		System.out.println(solution(priorities,location));
	}
	class Document{
        int idx;
        int order;
        public Document(int idx,int order){
            this.idx = idx;
            this.order = order;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> printer = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            printer.offer(new Document(i,priorities[i]));
        }
        loop: while(!printer.isEmpty()){
            
            Document document = printer.poll();
            boolean flag = true;
            for(Document d : printer){
                if(document.order<d.order){
                    flag = false;
                    printer.offer(document);
                    break;
                }
            }
            if(flag) answer++;
            if(flag && document.idx == location) break loop;
            
        }
        
        return answer;
    }

}
