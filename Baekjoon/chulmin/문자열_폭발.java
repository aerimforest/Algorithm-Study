import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발 {
	static StringBuilder answer;
	static char trigger;
	static String line, bomb;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
		for(char c : line.toCharArray()) {
			answer.append(c);
			if(c==trigger && answer.length() >= bomb.length()) {
				boolean isBomb = true;
				for(int i=1; i<bomb.length(); i++) {
					if(answer.charAt(answer.length()- i - 1)!= bomb.charAt(bomb.length() - i - 1)) {
						isBomb = false;
					}
				}
				if(isBomb) {
					answer.delete(answer.length()- bomb.length(), answer.length());
				}
			}
		}
		if(answer.length()==0) {
			answer.append("FRULA");
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();
		line = br.readLine();
		bomb = br.readLine();
		trigger = bomb.charAt(bomb.length()-1);
		
		br.close();
	}
}
