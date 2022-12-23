import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] arr;
    static Point[][] connect;   //시작하는 위치에 연결이 되어있고, 시작하는 위치에 연결된 개수가 들어 있음
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new char[N][M];
        connect = new Point[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        connectZero();
        eachWallBreak();
    }

    private static void eachWallBreak() {
        for(int i = 0; i < N ; i++){
            String output = "";
            for(int j = 0; j < M; j++){
                if(arr[i][j] == '0') {
                    output += 0;
                    continue;
                }
                int result = 1;

                Set<Point> set = new HashSet<>();
                for(int k = 0; k < 4; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == '1') continue;

                    set.add(connect[connect[x][y].x][connect[x][y].y]);
                }

                for(Point point : set){
                    result += connect[point.x][point.y].value;
                }

                output += (result % 10);
            }

            System.out.println(output);
        }
    }

    private static void connectZero() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == '1' || connect[i][j] != null) continue;

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i,j));
                connect[i][j] = new Point(i,j);
                int count = 1;

                while(!queue.isEmpty()){
                    Point target = queue.poll();
                    for(int k = 0; k < 4; k++){
                        int x = target.x + dx[k];
                        int y = target.y + dy[k];
                        if(x < 0 || x >= N || y < 0 || y >= M || connect[x][y] != null || arr[x][y] == '1') continue;

                        connect[x][y] = connect[i][j];
                        queue.add(new Point(x,y));
                        count++;
                    }
                }

                connect[i][j].setValue(count % 10);
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int value;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
