import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	static int n, ans;
	static char[][] map;
	static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    n = Integer.parseInt(br.readLine());
	   
	    map = new char[n][n];
	    Point[] loc = new Point[3];
	    int x = 0;
	    for (int i = 0; i < n; i++) {
	    	String s = br.readLine();
	    	for (int j = 0; j < n; j++) {
	    		map[i][j] = s.charAt(j);
	    		if (map[i][j] == 'B')
	    			loc[x++] = new Point(i, j);		
	    	}
	    }
	    
	    ans = 0;
	    bfs(loc);
	    System.out.println(ans);
	}
	
	public static void bfs(Point[] loc) {
		boolean[][] visit = new boolean[n][n];
		Queue<Set> q = new ArrayDeque<>();
		q.add(new Set(loc, 0));
		
		while (!q.isEmpty()) {
			Set s = q.poll();
			
			int cnt = 0;
			for (int i = 0; i < 3; i++)
				if (map[s.p[i].x][s.p[i].y] == 'E')
					cnt++;
			
			if (cnt == 3) {
				ans = Math.min(ans, s.num);
			}
			
			for (int i = 0; i < 3; i++)
				visit[s.p[i].x][s.p[i].y] = true;
			
			for (int k = 0; k < 4; k++) {
				cnt = 0;
				Point[] tmp = new Point[3];
				for (int i = 0; i < 3; i++) {
					int nx = s.p[i].x + dx[k], ny = s.p[i].y + dy[k];
					if (range(nx, ny) && map[nx][ny] == '0' && !visit[nx][ny])
						tmp[cnt++] = new Point(nx, ny);
				}
				if (cnt == 3) {
					for (int i = 0; i < 3; i++) {
						visit[s.p[i].x][s.p[i].y] = false;
						map[s.p[i].x][s.p[i].y] = '0';
						map[tmp[i].x][tmp[i].y] = 'B';
					}
					q.add(new Set(tmp, s.num + 1));
				}
			}
		}
		return;
	}
	
	public static boolean range(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
		return false;
	}
	static class Set{
		Point[] p;
		int num;
		
		public Set (Point[] p, int num) {
			this.p = p;
			this.num = num;
		}
	}

}
