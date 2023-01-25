import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static List<Point> list;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        map = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
        	StringBuilder s = new StringBuilder(br.readLine());
        	for (int j = 0; j < 9; j++) {
        		map[i][j] = s.charAt(j) - '0';
        		if (map[i][j] == 0) list.add(new Point(i, j));
        	}
        }
        
        dfs(0);
    }
    
    public static void dfs(int cnt) { // 백트래킹
    	if (cnt == list.size()) {
    		for (int i = 0; i < 9; i++) {
    			for (int j = 0; j < 9; j++)
    				System.out.print(map[i][j]);
    			System.out.println();
    		}	
    		System.exit(0);
    	}
    	
    	int x = list.get(cnt).x, y = list.get(cnt).y;
    	
    	boolean[] visit = new boolean[10]; //이미 쓴 숫자 체크
    	
    	for (int i = 0; i < 9; i++) // 가로
    		if (map[x][i] != 0)
    			visit[map[x][i]] = true;
    	
    	for (int i = 0; i < 9; i++) // 세로
    		if (map[i][y] != 0)
    			visit[map[i][y]] = true;
    	
    	int sx = (x / 3) * 3, sy = (y / 3) * 3;
    	for (int i = sx; i < sx + 3; i++) { //9칸
    		for (int j = sy; j < sy + 3; j++)
    			if(map[i][j] != 0)
    				visit[map[i][j]] = true;
    	}
    	
    	for (int i = 1; i < 10; i++) {//쓰지 않은 숫자 넣어줌
    		if(!visit[i]) {
    			map[x][y] = i;
    			dfs(cnt + 1);
    			map[x][y] = 0;
    		}
    	}
    }
}
