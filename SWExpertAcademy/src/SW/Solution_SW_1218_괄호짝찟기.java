package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution_SW_1218_괄호짝찟기 {
	static int T = 10;
	static char[] arr;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		Stack<Character> st = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		map.put('<', '>');

		for (int i = 1; i <= T; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr = bf.readLine().toCharArray();
			result = 1;
			for (int j = 0; j < num; j++) {
				// key [({ 등이면 넣고
				if (map.containsKey(arr[j])) {
					st.push(arr[j]);
					// value가 )}] 일때 스택빼는거랑 비교해서 맞으면 1 틀리면 0
				} else if (map.containsValue(arr[j])) {

					if (map.get(st.peek()) == arr[j]) {
						st.pop();
					} else {
						result = 0;
						break;
					}
				}
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
