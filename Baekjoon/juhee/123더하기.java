import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] num = new int[12];
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		for (int i = 4; i < 12; i++) {
			for (int j = i-3; j < i; j++) {
				num[i] +=num[j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(num[N]).append("\n");
		}
        System.out.println(sb);
	}

}
