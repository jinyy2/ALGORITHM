package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SW_1224_계산기3 {
	static int T = 10;
	static char[] arr;
	static char[] arr2;
	static int result;

	static int sum;

	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		Stack<Integer> sum = new Stack<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= T; i++) {
			int num = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			arr = str.toCharArray();
			String post = "";

			for (int j = 0; j < arr.length; j++) {
				// (
				if (arr[j] == '(') {
					stack.push(arr[j]);
					// )
				} else if (arr[j] == ')') {
					while (stack.peek() != '(') {
						post += stack.peek();
						stack.pop();
					}
					stack.pop(); // (를 제거한다

					// + or *
				} else if (arr[j] == '+' || arr[j] == '*') {
					if (stack.peek() == '(') {
						stack.push(arr[j]);
					} else if (stack.peek() == '*' && arr[j] == '+') {
						post += stack.peek();
						stack.pop();
						stack.push(arr[j]);
					} else if (stack.peek() == '+' && arr[j] == '*') {
						stack.push(arr[j]);
//	                          stack.pop();
					} else if (stack.peek() == arr[j]) { // while
						post += stack.peek();
						stack.pop();
						stack.push(arr[j]);
					}
				}
				// 문자
				else {
					post += arr[j];
				}
			}
//	          / 나머지
//	          while (!stack.isEmpty()) {
//	              post += stack.peek();
//	              stack.pop();
//	          }

			arr2 = post.toCharArray();
			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j] == '+') {
					int a = sum.peek();
					sum.pop();
					int b = sum.peek();
					sum.pop();
					sum.push(a + b);
				} else if (arr2[j] == '*') {
					int c = sum.peek();
					sum.pop();
					int d = sum.peek();
					sum.pop();
					sum.push(c * d);
				} else {
					sum.push(arr2[j] - '0');
				}
			}
			result = sum.peek();

//	          System.out.println("#" + i + " " + post);
			System.out.println("#" + i + " " + result);
		}
	}
}
