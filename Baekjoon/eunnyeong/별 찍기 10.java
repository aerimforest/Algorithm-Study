import java.util.*;

public class Main {
	
	static char[][] a;
	
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		a = new char[n][n];
		star(0, 0, n, false);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				sb.append(a[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void star(int x, int y, int n, boolean blank) {
		if (blank) {
			for (int i = x; i < x + n; i++)
				for (int j = y; j < y + n; j++)
					a[i][j] = ' ';
			return;
		}
		
		if (n == 1) {
			a[x][y] = '*';
			return;
		}
		
		int size = n / 3, cnt = 0;
		for (int i = x; i < x + n; i += size) {
			for (int j = y; j < y + n; j += size) {
				cnt++;
				boolean f = false;
				if (cnt == 5)
					f = true;
				star(i, j, size, f);
			}
		}
	}
}
