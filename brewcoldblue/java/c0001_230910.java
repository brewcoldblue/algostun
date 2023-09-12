import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c0001_230910 {
	public static void main(String[] args) {

		// String[] rcv = {"george", "jin", "david"};
		// String[][] emp = {{"george", "it"}, {"jin", "it"}, {"david", "security"}, {"thomas", "security"}, {"isla", "it"}, {"ava", "it"}, {"evans", "security"}};
		String[] rcv = {"george", "jin", "david", "thomas", "isla"};
		String[][] emp = {{"george", "it"}, {"jin", "it"}, {"david", "security"}, {"thomas", "security"}, {"isla", "it"}, {"ava", "it"}, {"evans", "security"}};

		Map<String, ArrayList<String>> TEAM = new HashMap<>();
		Map<String, String> IND = new HashMap<>();
		Map<String, Integer> RCVSIZE = new HashMap<>();

		for(String[] p : emp) {
				ArrayList<String> list = TEAM.containsKey(p[1]) ? TEAM.get(p[1]) : new ArrayList<>();
				list.add(p[0]);
				TEAM.put(p[1], list); //팀 : [개인, 개인]
				IND.put(p[0], p[1]); //개인 : 팀
		}

		for(String target : rcv) {
			int 팀별수신자수 = RCVSIZE.getOrDefault(IND.get(target), 0); //get해보고 없으면 0으로 하는 메서드가 있길래 써봄
			RCVSIZE.put(IND.get(target), ++팀별수신자수); //팀 : 수신자수
		}
		for(String 팀 : TEAM.keySet()) {
			RCVSIZE.putIfAbsent(팀, 0); //없으면 put하는 메서드가 있길래 써봄
		}

		int t = 0;

		for(String 팀 : TEAM.keySet()) {
		/** 특정 팀 전체를 추가해야하는 경우는
		 * 1 + (안받는 팀원수) < 메시지 받는 팀원수인 경우임
		 */
			if(1 + TEAM.get(팀).size() - RCVSIZE.get(팀) <= RCVSIZE.get(팀)) {
				t = t + 1 + TEAM.get(팀).size() - RCVSIZE.get(팀);
			} else t = t + RCVSIZE.get(팀);	
		}

		System.out.println(t);
	}
}
