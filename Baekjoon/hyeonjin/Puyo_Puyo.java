import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean end = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[12][6];
        for(int i = 0; i < 12; i++){
            String s = br.readLine();
            for(int j = 0; j < 6; j++){
                map[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        while(!end){
            end = true;

            check = new boolean[12][6];
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(map[i][j] == '.')
                        continue;

                    if(!check[i][j]){
                        checkPop(i, j);
                    }
                }
            }

            if(!end) {
                cnt++;
                //내리기
                for (int j = 0; j < 6; j++) {
                    for (int i = 1; i < 12; i++) {
                        if (map[i][j] == '-') {
                            for (int k = i; k > 0; k--) {
                                map[k][j] = map[k - 1][j];
                            }
                            map[0][j] = '.';
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static void checkPop(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> pointList = new ArrayList<>();

        queue.add(new Point(x,y));
        pointList.add(new Point(x,y));
        check[x][y] = true;
        char c = map[x][y];

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int k = 0; k < 4; k++){
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if(xx >= 0 && xx < 12 && yy >= 0 && yy < 6 && !check[xx][yy] && map[xx][yy] == c){
                    queue.add(new Point(xx,yy));
                    pointList.add(new Point(xx,yy));
                    check[xx][yy] = true;
                }
            }
        }

        if(pointList.size() >= 4){
            for(Point p : pointList){
                map[p.x][p.y] = '-';
            }
            end = false;
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
