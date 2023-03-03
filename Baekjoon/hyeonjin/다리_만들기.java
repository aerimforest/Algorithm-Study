import java.io.*;
import java.util.*;

public class 다리_만들기 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] || arr[i][j] == 0) continue;

                Queue<Point> queue = new LinkedList<>();
                Queue<Point> findLand = new LinkedList<>();
                queue.add(new Point(i,j));
                findLand.add(new Point(i,j));
                check[i][j] = true;

                //땅 찾기
                while(!findLand.isEmpty()){
                    Point p = findLand.poll();

                    for(int k = 0; k < 4; k++){
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];

                        if(x < 0 || x >= N || y < 0 || y >= N || check[x][y] || arr[x][y] == 0) continue;

                        queue.add(new Point(x,y));
                        findLand.add(new Point(x,y));
                        check[x][y] = true;
                    }
                }

                //제일 가까운 땅 찾기
                boolean find = false;
                int cnt = 0;
                boolean[][] newCheck = new boolean[N][N];
                while(!queue.isEmpty() && !find){
                    int size = queue.size();
                    for(int s = 0; s < size; s++){
                        Point p = queue.poll();

                        for(int k = 0; k < 4; k++){
                            int x = p.x + dx[k];
                            int y = p.y + dy[k];

                            if(x < 0 || x >= N || y < 0 || y >= N || newCheck[x][y] || check[x][y]) continue;

                            if(arr[x][y] == 1){
                                find = true;
                                min = Math.min(min, cnt);
                                break;
                            }

                            newCheck[x][y] = true;
                            queue.add(new Point(x,y));
                        }

                        if(find) break;
                    }

                    cnt++;
                }
            }
        }

        System.out.println(min);
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
