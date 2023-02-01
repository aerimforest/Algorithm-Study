import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 미로_탐색 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] check = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        int cnt = 1;
        while(!queue.isEmpty()){
            cnt++;

            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                for(int k = 0; k < 4; k++){
                    int x = point.x + dx[k];
                    int y = point.y + dy[k];

                    if(x == N - 1 && y == M - 1){
                        System.out.println(cnt);
                        return;
                    }

                    if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == 0 || check[x][y]) continue;

                    queue.add(new Point(x,y));
                    check[x][y] = true;
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
