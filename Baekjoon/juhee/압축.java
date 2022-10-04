package _202210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 시간 : 80ms
// 메모리 : 11524
public class BOJ_1662_압축_골드5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : str) {
			stack.push(c);
		}
		
		System.out.println(cal_len(stack));
	}

	private static int cal_len(Stack<Character> stack) {
		
		int len = 0;
		while(!stack.isEmpty()) {
			char cur = stack.pop();
			System.out.println("cur : " + cur);
			if(cur == ')') {
				int tmp = cal_len(stack);
				char next = stack.pop();
				len += (next-'0') * tmp;
			} else if(cur == '(') {
				return len;
			} else {
				len++;
			}
			System.out.println(len);
		}
		return len;
	}

	

}
