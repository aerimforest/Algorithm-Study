import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 204ms
// 메모리 : 12124KB
public class Main {

	static int K;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int N2 = N*2;
		
		int[] con = new int[N2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N2; i++) {
			con[i] = Integer.parseInt(st.nextToken());
		}
		int[] robot = new int[N2];
		
		int on = 0;
		int off = N-1;
		
		int time = 0;
		while(check(con)) {
			// 벨트 회전
			if(--on == -1) {
				on = N2 - 1;
			}
			if(--off == -1) {
				off = N2 - 1;
			}
			if(robot[off] != 0) {
				robot[off] = 0;
			}
			// 로봇 움직임
			move_robot(con, robot, off);
			if(con[on] > 0 && robot[on] == 0) {
				robot[on] = 1;
				con[on]--;
			}
			time++;
		}
		System.out.println(time);
	}

	private static void move_robot(int[] con, int[] robot, int off) {
		
		int N = robot.length;
		for (int i = 1; i < N; i++) {
			int n = off - i;
			if(n < 0) n += N;
			if(robot[n] == 0) continue;
			int next = n + 1;
			if(next == N) next = 0;
			if(robot[next] == 1 || con[next] <= 0) continue;
			robot[next] = robot[n];
			robot[n] = 0;
			if(next == off) robot[next] = 0;
			con[next]--;
		}
	}

	private static boolean check(int[] con) {

		int cnt = 0;
		for (int i : con) {
			if(i == 0) cnt++;
			if(cnt >= K) return false;
		}
		return true;
	}

}
