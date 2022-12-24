import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int R, C, N;
    static char[][] A;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Dot> drop_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                A[i][j] = s.charAt(j);
            }
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            // 막대기를 던진다
            throwStick(height, i);
            if (isSeperated()) { // 클러스터가 분리된지 확인한다
                gravity();// 중력을 작용한다
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(A[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Dot implements Comparable<Dot> {
        int x, y;

        public Dot (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot o) {
            return o.x - this.x;
        }
    }

    static void bfs(int sx, int sy) {
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(sx, sy)); // 시작 미네랄 큐에 넣기
        visited[sx][sy] = true; // 시작 미네랄 방문 체크
        while (!Q.isEmpty()) {
            Dot dot = Q.poll();
            int x = dot.x, y = dot.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1]; // 다음 방문할 장소
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 범위를 벗어나면
                if (A[nx][ny] == '.') continue; // 미네랄이 아니면
                if (visited[nx][ny]) continue; // 이미 방문 했으면
                visited[nx][ny] = true;
                Q.add(new Dot(nx, ny));
            }
        }
    }

    static boolean isSeperated() {
        visited = new boolean[R][C];
        for (int j = 0, r = R -1; j < C; j++) {
            if (A[r][j] == 'x' && !visited[r][j]) {
                bfs(r, j); // 바닥에 붙어 있는 미네랄 체크
            }
        }
        drop_list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 'x' && !visited[i][j]) { // 떨어질 미네랄이 있으면
                    drop_list.add(new Dot(i, j));
                }
            }
        }
        return drop_list.size() > 0;
    }

    static void gravity() {
        // 떨어지는 동안 클러스터의 모양은 변하지 않는다.
        // 두 개 또는 그 이상의 클러스터가 동시에 떨어지는 경우도 없다 -> 떨어지는 클러스터는 항상 1개
//        for (int i = R - 1; i >= 0; i--) {
//            for (int j = 0; j < C; j++) {
//                if (A[i][j] == 'x' && !visited[i][j]) { // 중력을 작용해야하는 클러스터이면
//                    // 가능한 밑으로 내려간다
//                    int newi = i;
//                    for (int ii = i + 1; ii < R; ii++) {
//                        if (A[ii][j] ==  'x') break; // 미네랄이 있으면
//                        newi = ii;
//                    }
//                    A[newi][j] = A[i][j]; // 중력이 작용한 칸으로 이동
//                    A[i][j] = '.'; // 이전 칸은 빈칸
//                }
//            }
//        }
        boolean flag = true;
        for (Dot dot: drop_list) {
            int nx = dot.x + 1, y = dot.y; // 다음 위치
            if (nx >= R || visited[nx][y]) { // 줄의 범위를 벗어 났거나 바닥과 연결된 미네랄이 있으면
                flag = false;
                break;
            }
        }
        while (flag) {
            // 떨어질 미네랄 한칸씩 밑으로 이동
            ArrayList<Dot> new_list = new ArrayList<>();
            Collections.sort(drop_list);
            for (Dot dot: drop_list) {
                int nx = dot.x + 1, y = dot.y; // 다음 위치
                A[nx][y] = 'x'; // 한칸 밑으로 미네랄 이동
                A[dot.x][dot.y] = '.'; // 이동 전칸 비운다
                new_list.add(new Dot(nx, y));
            }
            drop_list = new_list;
            for (Dot dot: drop_list) {
                int nx = dot.x + 1, y = dot.y; // 다음 위치
                if (nx >= R || visited[nx][y]) { // 줄의 범위를 벗어 났거나 바닥과 연결된 미네랄이 있으면
                    flag = false;
                    break;
                }
            }
        }
    }

    static void throwStick(int height, int dir) {
        height = R - height;
        if (dir % 2 == 0) { // 왼쪽에서 오른쪽으로 던질 때
            for (int y = 0; y < C; y++) {
                if (A[height][y] == 'x') { // 미네랄을 맞췄울 때
                    A[height][y] = '.'; // 해당 미네랄을 부순다
                    return;
                }
            }
        } else { // 오른쪽에서 왼쪽으로 던질 때
            for (int y = C - 1; y >= 0; y--) {
                if (A[height][y] == 'x') { // 미네랄을 맞췄울 때
                    A[height][y] = '.'; // 해당 미네랄을 부순다
                    return;
                }
            }
        }
    }
}
