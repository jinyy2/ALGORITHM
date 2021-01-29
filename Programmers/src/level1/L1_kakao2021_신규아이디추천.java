package level1;

public class L1_kakao2021_신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution2(new_id));

	}
	
	public static String solution2(String new_id) {
		String answer = "";
		//1
		new_id = new_id.toLowerCase();
		
		//2
		new_id = new_id.replaceAll("[^0-9a-z-_.]", "");
		//3
		new_id = new_id.replaceAll("[.]+", ".");
		//4
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		//5
		if(new_id.equals(""))new_id+="a";
		//6
		if(new_id.length()>=16) {
			new_id = new_id.substring(0,15);
			new_id = new_id.replaceAll("^[.]|[.]$", "");
		}
		//7
		while(new_id.length()<3) {
			new_id+=new_id.charAt(new_id.length()-1);
		}
		answer = new_id;
		return answer;
	}
	public static String solution(String new_id) {
		String answer = "";
		// 1단계 소문자
		new_id = new_id.toLowerCase();
		// 2단계 소문자, 숫자, 빼기, 밑줄, 마침표 제외 제거
		String new_id2 = "";
		for (int i = 0; i < new_id.length(); i++) {
			int temp = (int) new_id.charAt(i);
			if (('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') || (97 <= temp && temp <= 122) || temp == 45
					|| temp == 95 || temp == 46)
				new_id2 += new_id.charAt(i);

		}

		// 3단계
		String new_id3 = "" + new_id2.charAt(0);
		for (int i = 1; i < new_id2.length(); i++) {
			if (new_id2.charAt(i) == '.' && new_id2.charAt(i - 1) == '.')
				continue;
			new_id3 += new_id2.charAt(i);
		}
		// 4단계
		String id4 = "";
		for (int i = 0; i < new_id3.length(); i++) {
			if (i == 0 && new_id3.charAt(i) == '.')
				continue;
			if (i == new_id3.length() - 1 && new_id3.charAt(i) == '.')
				continue;
			id4 += new_id3.charAt(i);
		}
		// 5단계
		String id5 = "";
		if (id4.equals(id5))
			id5 += "a";
		else
			id5 = id4;

		// 6단계
		String id6 = "";
		if (id5.length() >= 16) {
			id6 = id5.substring(0, 15);
			if (id6.charAt(0) == '.')
				id6 = id6.substring(1, id6.length());
			if (id6.charAt(id6.length() - 1) == '.')
				id6 = id6.substring(0, id6.length() - 1);
		} else {
			id6 = id5;
		}

		// 7단계
		char ch = id6.charAt(id6.length() - 1);
		while (id6.length() <= 2) {
			id6 += ch;
		}
		answer = id6;
		return answer;
	}

}
