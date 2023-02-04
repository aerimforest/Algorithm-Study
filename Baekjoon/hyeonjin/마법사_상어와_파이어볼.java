import java.io.*;
import java.util.*;

public class 마법사_상어와_파이어볼 {
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static int N;
    static int M;
    static int K;
    static List<FireBall>[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());

        arr = new List[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int r = Integer.valueOf(str.nextToken());
            int c = Integer.valueOf(str.nextToken());
            int m = Integer.valueOf(str.nextToken());
            int s = Integer.valueOf(str.nextToken());
            int d = Integer.valueOf(str.nextToken());

            arr[r - 1][c - 1].add(new FireBall(r - 1,c - 1, m, s, d));
        }

        move();
        checkEmptyFireBall();
    }

    private static void checkEmptyFireBall() {
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(FireBall f : arr[i][j]){
                    result += f.mass;
                }
            }
        }
        System.out.println(result);
    }

    private static void move() {
        for(int k = 0; k < K; k++){
            moveFireBall();
            checkMergeFireBall();
        }
    }

    private static void checkMergeFireBall() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j].size() > 1){
                    mergeFireBall(i, j);
                }
            }
        }
    }

    private static void mergeFireBall(int x, int y) {
        int mass = 0;
        int speed = 0;
        int direct = 0;
        int size = arr[x][y].size();
        for(FireBall fire : arr[x][y]){
            mass += fire.mass;
            speed += fire.speed;
            direct += fire.direct % 2;
        }

        arr[x][y].clear();
        mass /= 5;

        if(mass == 0) return;

        speed /= size;

        //모두 홀수 or 모두 짝수가 아닌 경우
        if(direct > 0 && direct < size) direct = 1;
        else direct = 0;

        for(int i = direct; i < 8; i += 2){
            arr[x][y].add(new FireBall(x, y, mass, speed, i));
        }
    }

    private static void moveFireBall() {
        List<FireBall> moved = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < arr[i][j].size(); k++){
                    FireBall target = arr[i][j].get(k);

                    int r = target.r + dr[target.direct] * target.speed;
                    int c = target.c + dc[target.direct] * target.speed;

                    if(r < 0) {
                        while(r < 0){
                            r += N;
                        }
                    }
                    else r %= N;

                    if(c < 0) {
                        while(c < 0){
                            c += N;
                        }
                    }
                    else c %= N;

                    moved.add(new FireBall(r, c, target.mass, target.speed, target.direct));
                }

                arr[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < moved.size(); i++){
            FireBall fireball = moved.get(i);
            arr[fireball.r][fireball.c].add(fireball);
        }
    }

    public static class FireBall{
        int r;
        int c;
        int mass;
        int speed;
        int direct;

        public FireBall(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.mass = m;
            this.speed = s;
            this.direct = d;
        }
    }
}
