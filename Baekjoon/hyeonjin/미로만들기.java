import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 미로만들기 {
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};
    static int N;
    static int[][] arr;
    static int[][] distance;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        arr = new int[N][N];
        distance = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j));
                distance[i][j] = 2500;
            }
        }

        checkArrive();
        System.out.println(distance[N-1][N-1]);
    }


    private static void checkArrive() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        distance[0][0] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];

                if(x < 0 || x >= N || y < 0 || y >= N || distance[x][y] <= distance[p.x][p.y]) continue;

                if(arr[x][y] == 0) distance[x][y] = distance[p.x][p.y] + 1;
                else distance[x][y] = distance[p.x][p.y];

                queue.add(new Point(x,y));
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
