import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] arr;
    static int N;
    static int[] height;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());
        arr = new char[R][C];

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        N = Integer.valueOf(br.readLine());
        height = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            height[i] = Integer.valueOf(str.nextToken());
        }
        boolean isLeft = false;
        for(int i = 0; i < N; i++){
            isLeft = !isLeft;
            int selectHeight = R - height[i];
            if(!throwStick(selectHeight, isLeft)) continue;
            downCluster();
        }

        for(int i = 0; i < R; i++){
            String result = "";
            for(int j = 0; j < C; j++){
                result += arr[i][j];
            }
            System.out.println(result);
        }
    }

    private static void downCluster() {
        check = new boolean[R][C];

        for(int i = R - 2; i >= 0; i--){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == '.' || check[i][j]) continue;

                if(findCluster(i, j)) return;
            }
        }
    }

    private static boolean findCluster(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> cluster = new ArrayList<>();
        queue.add(new Point(x,y));
        cluster.add(new Point(x,y));
        check[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int k = 0; k < 4; k++){
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if(xx < 0 || xx >= R || yy < 0 || yy >= C || arr[xx][yy] == '.' || check[xx][yy]) continue;

                queue.add(new Point(xx,yy));
                cluster.add(new Point(xx,yy));
                check[xx][yy] = true;
            }
        }

        if(!checkCluster(cluster)) return false;

        fallCluster(cluster);
        return true;
    }

    private static void fallCluster(List<Point> cluster) {
        //클러스터가 존재하는 높이 체크
        int[] bottom = new int[C];
        boolean[] isExist = new boolean[C];
        int min = R;
        for(Point p : cluster){
            bottom[p.y] = Math.max(bottom[p.y], p.x);
            isExist[p.y] = true;
        }


        for(int j = 0; j < C; j++){
            if(!isExist[j]) continue;
            min = Math.min(min, R - 1 - bottom[j]);
            for(int i = bottom[j] + 1; i < R; i++){
                if(arr[i][j] == 'x') {
                    min = Math.min(min, i - bottom[j] - 1);
                    break;
                }
            }
        }

        //클러스터 내리기
        Collections.sort(cluster);
        for(Point p : cluster){
            arr[p.x + min][p.y] = 'x';
            arr[p.x][p.y] = '.';
        }
    }

    //바닥에 닿는것이 있으면 클러스터가 아님
    private static boolean checkCluster(List<Point> cluster) {
        for(Point p : cluster){
            if(p.x == R - 1) return false;
        }

        return true;
    }

    private static boolean throwStick(int selectHeight, boolean isLeft) {
        if(isLeft) {
            for (int j = 0; j < C; j++) {
                if (arr[selectHeight][j] == 'x') {
                    arr[selectHeight][j] = '.';
                    return true;
                }
            }
        }
        else{
            for(int j = C - 1; j >= 0; j--){
                if (arr[selectHeight][j] == 'x') {
                    arr[selectHeight][j] = '.';
                    return true;
                }
            }
        }

        return false;
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p){
            if(p.x != x) return p.x - x;

            return p.y - y;
        }
    }
}
