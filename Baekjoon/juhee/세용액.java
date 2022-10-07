import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 576ms
// 메모리 : 14264KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(num);
		long min = Long.MAX_VALUE;
		int node1 = -1;
		int node2 = -1;
		int node3 = -1;

		for (int i = 0; i < N; i++) {
			for (int j = i+2; j < N; j++) {
				int mid = find_mid(i, j, num);
				long tmp = (long) num[i] + num[j] + num[mid];
				if(Math.abs(tmp) < min) {
					min = Math.abs(tmp);
					node1 = num[i];
					node2 = num[mid];
					node3 = num[j];
				}
			}
		}

		System.out.println(node1 + " " + node2 + " " + node3);
	}

	private static int find_mid(int p, int m, int[] num) {

		int start = p + 1;
		int end = m - 1;
		if(start == end) return p+1;
		long pm = - (num[p] + num[m]);
		while(start <= end) {
			int mid = (start + end) / 2;
			long tmp = num[mid];
			if(pm == tmp) {
				return mid;
			} else if(pm > tmp) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(Math.abs(num[start] + pm) > Math.abs(num[end]+pm)) {
			return end;
		} else return start;
	}


}
