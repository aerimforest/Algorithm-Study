import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 달이_차오른다_가자 {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Point start;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][64];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == '0') start = new Point(i,j,0);
            }
        }

        boolean find = go(start);
        if(!find) System.out.println("-1");
    }

    private static boolean go(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = true;

        int move = 0;
        while(!queue.isEmpty()){
            move++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();

                for(int k = 0; k < 4; k++){
                    int x = p.x + dx[k];
                    int y = p.y + dy[k];
                    if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == '#' || visited[x][y][p.key]) continue;

                    if(arr[x][y] == '1') {
                        System.out.println(move);
                        return true;
                    }

                    //열쇠를 만난 경우
                    if(arr[x][y] >= 'a' && arr[x][y] <= 'f'){
                        int key = 1 << (arr[x][y] - 'a');
                        key = key | p.key;
                        if(!visited[x][y][key]){
                            queue.add(new Point(x, y, key));
                            visited[x][y][key] = true;
                        }
                    }
                    //문
                    else if(arr[x][y] >= 'A' && arr[x][y] <= 'F'){
                        int door = 1 << (arr[x][y] - 'A');
                        if((p.key & door) == 0) continue;

                        visited[x][y][p.key] = true;
                        queue.add(new Point(x,y,p.key));
                    }
                    else{
                        queue.add(new Point(x,y,p.key));
                        visited[x][y][p.key] = true;
                    }
                }
            }
        }

        return false;
    }

    public static class Point{
        int x;
        int y;
        int key;
        public Point(int x, int y, int key){
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
}
