import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static int n;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static int[][] bombCount;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        bombCount = new int[r][c];

        for (int i = 0; i < r; i++) {
            s = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'O') {
                    bombCount[i][j] = 0;
                }
                else {
                    bombCount[i][j] = -1;
                }
            }
        }
        boom(0);
    }

    static void boom(int startSecond) {

        for (int i = 1; i <= n; i++) {
            if (i == 1) continue;

            if (i % 2 == 0) {
                setBomb(i);
            }
            else {
                bfs(i);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void bfs(int time) {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    if (time - 3 == bombCount[i][j]) {
                        queue.add(new Location(i, j));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            map[current.x][current.y] = '.';
            bombCount[current.x][current.y] = -1;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    map[nx][ny] = '.';
                    bombCount[nx][ny] = -1;
                }
            }
        }


    }

    static void setBomb(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = 'O';

                if (bombCount[i][j] == -1) {
                    bombCount[i][j] = time;
                }
            }
        }
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}