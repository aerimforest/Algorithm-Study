import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] memo = new int[N+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
	
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
					memo[i][j] += memo[i-1][k];
					memo[i][j] %= 10007;
			}
		}
		
		System.out.println(memo[N][0] % 10007); 
	}

}
