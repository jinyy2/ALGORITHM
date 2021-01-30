package level2;

public class L2_kakao2018_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			String sk = "";
			sk = skill_trees[i].replaceAll("[^" + skill + "]", "");
			boolean flag = true;
			for (int j = 0; j < sk.length(); j++) {
				if (sk.charAt(j) != skill.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag)
				answer++;

		}

		return answer;
	}
}
