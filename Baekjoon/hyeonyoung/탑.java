import java.io.*;
import java.util.StringTokenizer;

// BOJ_2493


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] stack = new int[n+1][2];
		stack[0][0] = 100000010;
		stack[0][1] = 0;
		int top = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(stack[top][0] <= height) {
				// pop
				top--;
			}
			bw.write(stack[top][1] + " ");
			// push
			top++;
			stack[top][0] = height;
			stack[top][1] = i;
		}
		bw.flush();
		bw.close();
	}

}
