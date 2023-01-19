import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 불_ {
    static char[][] arr;
    static int R;
    static int C;
    static Queue<Point> jihoon;
    static Queue<Point> fire;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int time = 0;
    static boolean escape = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        R = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());
        arr = new char[R][C];
        jihoon = new LinkedList<>();
        fire = new LinkedList<>();

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'J') jihoon.add(new Point(i,j));
                if(arr[i][j] == 'F') fire.add(new Point(i,j));
            }
        }

        while(!jihoon.isEmpty()){
            time++;
            moveJihoon();
            moveFire();
        }

        if(escape) System.out.println(time);
        else System.out.println("IMPOSSIBLE");
    }

    private static void moveFire() {
        int size = fire.size();
        for(int i = 0; i < size; i++){
            Point point = fire.poll();
            for(int k = 0; k < 4; k++){
                int x = point.x + dx[k];
                int y = point.y + dy[k];

                if(x < 0 || x >= R || y < 0 || y >= C || arr[x][y] == 'F' || arr[x][y] == '#') continue;

                arr[x][y] = 'F';
                fire.add(new Point(x,y));
            }
        }
    }

    private static void moveJihoon() {
        int size = jihoon.size();
        for(int i = 0; i < size; i++){
            Point point = jihoon.poll();
            if(arr[point.x][point.y] != 'J') continue;

            for(int k = 0; k < 4; k++){
                int x = point.x + dx[k];
                int y = point.y + dy[k];

                if(x == -1 || x == R || y == -1 || y == C){
                    jihoon.clear();
                    fire.clear();
                    escape = true;
                    return;
                }

                if(arr[x][y] == '.') {
                    arr[x][y] = 'J';
                    jihoon.add(new Point(x,y));
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
