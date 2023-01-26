import java.util.*;
import java.io.*;

class Virus {
    int x;
    int y;
    int time;

    public Virus(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.time = level;
    }
}

public class Main {

    static int N, M;
    static int[] picked;

    static ArrayList<Virus> virusList = new ArrayList<>();

    static int[][] map;
    static boolean[][] isVisit;
    static int blank;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(input[j]);

                map[i][j] = num;

                if (num == 2) {
                    virusList.add(new Virus(i, j, 1));
                } else if (num == 0) {
                    blank++;
                }
            }
        }

        if (blank == 0) {
            System.out.println(0);
            return;
        }
        picked = new int[M];
        combination(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static void combination(int cnt, int cur) {
        if (cnt == M) {
            BFS();
            return;
        }

        for (int i = cur; i < virusList.size(); i++) {
            picked[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void BFS() {
        Queue<Virus> q = new LinkedList<>();
        isVisit = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            q.add(virusList.get(picked[i]));
            isVisit[virusList.get(picked[i]).x][virusList.get(picked[i]).y] = true;
        }

        int time = 0;
        int count = 0;

        while (!q.isEmpty()) {
            Virus v = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = v.x + dx[k];
                int ny = v.y + dy[k];

                time = v.time;

                if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || isVisit[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    isVisit[nx][ny] = true;
                    count++;
                    q.add(new Virus(nx, ny, v.time + 1));
                }

                if (map[nx][ny] == 2) {
                    isVisit[nx][ny] = true;
                    q.add(new Virus(nx, ny, v.time + 1));
                }
            }

            if (count == blank) {
                time++;
                break;
            }
        }

        if (count != blank) return;

        min = Math.min(min, time - 1);
    }

}