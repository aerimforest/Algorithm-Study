import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N <= K) {
            System.out.println(0);
            return;
        }
		int num = N;
		for (int i = 0; i < K-1; i++) {
			int base = 0;
			while(Math.pow(2, base) < num) {
				base++;
			}
			num -= Math.pow(2, base - 1);
		}
		int base = 0;
		while(Math.pow(2, base) < num) {
			base++;
		}
		System.out.println((int) Math.pow(2, base) - num);
	}

}
