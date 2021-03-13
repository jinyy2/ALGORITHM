package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			if (str.equals("."))
				break;
			str = str.replaceAll("[a-zA-Z .]+", "");
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						flag = false;
						break;
					} else {
						if (stack.peek() == '(' && ch == ')') {
							stack.pop();
						} else if (stack.peek() == '[' && ch == ']') {
							stack.pop();
						} else {
							flag = false;
							break;
						}
					}
				}
			}
			if (!stack.isEmpty())
				flag = false;
			System.out.println(flag == true ? "yes" : "no");

		}
	}

}
