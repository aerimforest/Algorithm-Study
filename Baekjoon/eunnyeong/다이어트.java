import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		int s1 = (int) Math.sqrt(g + 1); //최솟값: x^2 = g - 1
		int s2 = (g + 1) / 2; //최댓값: x = (g + 1) / 2, x^2 - y^2 = x + y이기 때문에
		
		int f = -1;
		for (int i = s1; i <= s2; i++) {
			for (int j = s2 - 1; j >= 1; j--) {
				if (j > i) continue;
				int sum = i * i - j * j;
				if (sum > g) break;
				if (sum == g) {
					System.out.println(i);
					f = 1;
				}
			}
		}
		if (f != 1)
			System.out.println(f);
	}
}