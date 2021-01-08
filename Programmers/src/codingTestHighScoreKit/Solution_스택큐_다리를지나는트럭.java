package codingTestHighScoreKit;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_스택큐_다리를지나는트럭 {

	public static void main(String[] args) {
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(2, 10, truck_weights));
	}

	static class Point {
		int w;
		int dir;

		public Point(int w, int dir) {
			this.w = w;
			this.dir = dir;
		}
//        public void move(){
//            dir++;
//        }

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;

		Queue<Point> queue = new LinkedList<>();
		Queue<Integer> t_w = new LinkedList<>();
		// truck_weights배열 큐에 넣기
		int weightOnBridge = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			t_w.offer(truck_weights[i]);
		}
		int firstTruckWeight = t_w.poll();
		weightOnBridge = firstTruckWeight;
		queue.offer(new Point(firstTruckWeight, 1)); // 처음 1회
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			// 1만큼 움직임
//            for(Point p : queue){
//                p.move();
//            }
//            if(queue.peek().dir>bridge_length){
//                    weightOnBridge -= queue.poll().w;
//                }
			for (int i = 0; i < qSize; i++) {
				Point tempPoint = queue.poll();
				tempPoint.dir += 1;
				if (tempPoint.dir > bridge_length) {
					weightOnBridge -= tempPoint.w;
					System.out.println(tempPoint.w + " " + answer);

				} else {
					queue.offer(tempPoint);
				}

			}

			if (t_w.size() != 0 && weightOnBridge + t_w.peek() <= weight) {
				int truck = t_w.poll();
				weightOnBridge += truck;
				queue.offer(new Point(truck, 1));
			}

			answer++;
		}

		return answer;
	}

}
