import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static char[][] A;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] group;
    static boolean[][] visited;
    static int[] group_size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        group = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j);
            }
        }// end of input

        // 0을 그룹으로 만들어 각각의 크기 계산
        visited  = new boolean[N][M]; // bfs로 방문한 칸 체크
        group_size = new int[N*M+1]; // k번째 그룹의 크기
        int num = 1; // 그룹의 번호
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == '0' && !visited[i][j]) {
                    bfs(i, j, num); // 해당 점을 포함하는 그룹의 크기 구하기
                    num++; // 그룹 번호 증가
                }
            }
        }
        // 1에서 방문할 수 있는 칸의 개수 계산
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == '1') { // 벽을 방문했으면
                    int size = 0; // 이동할 수 있는 칸의 수
                    for (int k = 0; k < 4; k++) { // 델타탐색
                        int nx = i + dir[k][0], ny = j + dir[k][1]; // 인접한 칸의 좌표
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 범위가 벗어 났으면
                        if (!set.contains(group[nx][ny])) { // 방문하지 않은 그룹이면
                            set.add(group[nx][ny]); // 빙문 그룹에 추가
                            size += group_size[group[nx][ny]]; // 그룹의 크기만큼 이동할 수 있는 칸의 수 추가
                        }
                    }
                    size++; // 자신의 자리 칸의 수 추가
                    size %= 10; // 10으로 나눈 나머지
                    sb.append(size); // 정답 기록
                    set.clear(); // 방문한 그룹 초기화
                } else { // 벽이 아닌 칸을 방문했을 때
                    sb.append("0"); // 정답 기록
                }
            }
            sb.append("\n"); // 다음줄
        }
        System.out.print(sb.toString());
    }

    static void bfs(int sx, int sy, int num) {
        int sum = 1;
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(sx, sy)); // 해당 점 방문 목록에 추가
        visited[sx][sy] = true; // 해당 점 방문 체크
        group[sx][sy] = num; // 해당 점의 그룹 번호
        while (!Q.isEmpty()) {
            Dot dot = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dot.x + dir[k][0], ny = dot.y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 범위가 벗어 났으면
                if (A[nx][ny] == '1') continue; // 벽이면
                if (visited[nx][ny]) continue; // 방문 했으면
                visited[nx][ny] = true; // 방문 체크
                group[nx][ny] = num; // 해당 점의 그룹 번호
                Q.add(new Dot(nx, ny)); // 빙문 목록에 추가
                sum++; // 그룹 크기 증가
            }
        }
        group_size[num] = sum;
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
