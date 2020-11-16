package level1;

import java.util.*;

public class L1_같은숫자는싫어 {
	public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
