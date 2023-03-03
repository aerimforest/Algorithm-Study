import java.io.*;
import java.security.cert.PolicyNode;
import java.util.*;

public class 적록색약 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N;
    static char[][] arr;
    static boolean[][][] check;
    static int[] count = {0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.valueOf(br.readLine());
        arr = new char[N][N];
        check = new boolean[N][N][2];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j][0]) bfs(i,j,0);
                if(!check[i][j][1]) bfs(i,j, 1);
            }
        }

        System.out.println(count[0] + " " + count[1]);
    }

    private static void bfs(int x, int y, int c) {
        count[c]++;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int k = 0; k < 4; k++){
                int xx = point.x + dx[k];
                int yy = point.y + dy[k];

                if(xx < 0 || xx >= N || yy < 0 || yy >= N || check[xx][yy][c]) continue;
                if(c == 0){
                    if(arr[point.x][point.y] == arr[xx][yy]) {
                        queue.add(new Point(xx, yy));
                        check[xx][yy][c] = true;
                    }
                }
                else{
                    if(arr[point.x][point.y] == arr[xx][yy]){
                        queue.add(new Point(xx,yy));
                        check[xx][yy][c] = true;
                    }
                    else if((arr[point.x][point.y] == 'R' || arr[point.x][point.y] == 'G') && (arr[xx][yy] == 'R' || arr[xx][yy] == 'G')){
                        queue.add(new Point(xx,yy));
                        check[xx][yy][c] = true;
                    }
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
