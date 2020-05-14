package D2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1966_숫자를정렬하자 {
	static int T;
	static int num;
	static int min;
	static int temp;
	static int[] arr2;
	static int index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			num = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			String[] arr = str.split(" ");
			arr2 = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				arr2[j] = Integer.parseInt(arr[j]);
			}
			for (int j = 0; j < arr2.length; j++) {
				min = 999;
				for (int k = j; k < arr2.length; k++) {
					if (arr2[k] < min) {
						min = arr2[k];
						index = k;
					}
				}
				temp = arr2[j];
				arr2[j] = min;
				arr2[index] = temp;
			}
			System.out.print("#" + (i + 1) + " ");
			for (int z = 0; z < arr.length; z++) {
				System.out.print(arr2[z] + " ");
			}
			System.out.println();
		}
	}
}
