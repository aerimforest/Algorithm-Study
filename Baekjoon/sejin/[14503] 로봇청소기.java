	
import java.util.*;
 
public class Main {    
    
    static int n, m, r, c, d;
    static int[][] board;
    static int count = 1; 
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        m = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        
        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        
        dfs(r, c, d);
        System.out.println(count);
    }    
    
    public static void dfs(int x, int y, int dir) {
        board[x][y] = 2; 
        
        for(int i = 0; i < 4; i++) {
            dir -= 1;
            if(dir == -1) dir = 3;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(board[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }
        
        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < n && by < m && board[bx][by] != 1) {
            dfs(bx, by, dir);
        }
    }
}
