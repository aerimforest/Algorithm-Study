import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 시간 : 76ms
// 메모리 : 11616KB
public class Main {

	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		if(str.length==1) {
			System.out.println(str[0]-'0');
			return;
		}
		max = Integer.MIN_VALUE;
		subset(1, new boolean[N/2], str); 
		System.out.println(max);
	}

	static int max;
	private static void subset(int cnt, boolean[] v, char[] str) {

		int M = v.length;
		if(cnt == M) {
			// 짝수번째에는 숫자 홀수번째에는 연산
			Deque<Integer> stack = new LinkedList<>();
			Deque<Character> op = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					stack.addLast(str[i]-'0');
				} else {
					if(v[i/2]) {
						int n = stack.removeLast();
						int m = str[i+1] - '0';
						int tmp = operation(n, m, str[i]);
						stack.addLast(tmp);
						i++;
					} else {
						op.addLast(str[i]);
					}
				}
			}
			
			int total = stack.removeFirst();
			while(!stack.isEmpty() && !op.isEmpty()) {
				char o = op.removeFirst();
				int m = stack.removeFirst();
				total = operation(total, m, o);
			}
			max = Math.max(total, max);
			return;
		}
		
		// 괄호 칠 연산을 정하기
		if(cnt-1 < 0 || !v[cnt-1]) {
			v[cnt] = true;
			subset(cnt+1, v, str);
		}
		v[cnt] = false;
		subset(cnt+1, v, str);
	}

	private static int operation(int n2, int m, char c) {

		int res = n2;
		switch (c) {
		case '+':
			return res + m;
		case '-':
			return res - m;
		case '*':
			return res * m;
		case '/':
			return res / m;
		}
		return -1;
	}

}
