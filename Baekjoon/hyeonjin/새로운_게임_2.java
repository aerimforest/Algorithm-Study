import java.io.*;
import java.util.*;

public class 새로운_게임_2 {
    public static int N;
    public static int K;
    public static int[][] map;
    public static Stack<Integer>[][] arr;
    public static Map<Integer, Piece> piece;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int target_x;
    public static int target_y;
    public static boolean result = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());
        piece = new HashMap();
        arr = new Stack[N][N];
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.valueOf(str.nextToken());
                arr[i][j] = new Stack();
            }
        }

        for(int i = 1; i <= K; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            int direct = Integer.valueOf(str.nextToken());

            piece.put(i, new Piece(x - 1, y - 1, direct - 1));
            arr[x - 1][y - 1].add(i);
        }

        for(int t = 1; t <= 1000; t++){
            move();

            if(result) {
                System.out.println(t);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void move() {
        for(int k = 1; k <= K; k++){
            Piece p = piece.get(k);
            List<Integer> items = new ArrayList<>(); //옮기는게 제일 마지막에 담김

            int size = arr[p.x][p.y].size();
            for(int i = 0; i < size; i++){
                items.add(arr[p.x][p.y].pop());
                if(items.get(i) == K) break;
            }

            target_x = p.x + dx[p.direct];
            target_y = p.y + dy[p.direct];

            if(target_x < 0 || target_x >= N || target_y < 0 || target_y >= N || map[target_x][target_y] == 2){
                blue(p, items);
            }
            else if(map[target_x][target_y] == 1){
                red(items);
            }
            else{
                white(items);
            }

            if(target_x >= 0 && target_x < N && target_y >= 0 && target_y < N && arr[target_x][target_y].size() >= 4){
                result = true;
                return;
            }
        }
    }

    private static void red(List<Integer> items) {
        for(int i = 0; i < items.size(); i++){
            int num = items.get(i);
            arr[target_x][target_y].add(num);

            Piece target = piece.get(num);
            piece.put(num, new Piece(target_x, target_y, target.direct));
        }
    }

    private static void white(List<Integer> items) {
        for(int i = items.size() - 1; i >= 0; i--){
            int num = items.get(i);
            arr[target_x][target_y].add(num);

            Piece target = piece.get(num);
            piece.put(num, new Piece(target_x, target_y, target.direct));
        }
    }

    private static void blue(Piece p, List<Integer> items) {
        int direct = p.direct;
        if(direct % 2 == 0) direct++;
        else direct--;

        p.direct = direct;
        target_x = p.x + dx[direct];
        target_y = p.y + dy[direct];

        if(target_x < 0 || target_x >= N || target_y < 0 || target_y >= N || map[target_x][target_y] == 2 ) {
            for(int i = items.size() - 1; i >= 0; i--){
                arr[p.x][p.y].add(items.get(i));
            }
            return;
        }

        if(map[target_x][target_y] == 1) red(items);
        else white(items);
    }

    public static class Piece{
        int x;
        int y;
        int direct;

        public Piece(int x, int y, int direct){
            this.x = x;
            this.y = y;
            this.direct = direct;
        }
    }
}
