import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static Queue<Integer> Q;
    static ArrayList<Integer>[] adj;
    static int[] indeg, building;
    static int[][] game;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        indeg = new int[N+1];
        game = new int[K][2];
        building = new int[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indeg[b]++;
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int ans = 1;
        for (int i = 0; i < K; i++) { // 게임 정보의 개수
            int cmd = game[i][0]; // 명령어
            int num = game[i][1]; // 건물 번호
            if (cmd == 1) { // 1개의 건물을 건설한다
                if (indeg[num] == 0) { // 건설이 가능하면
                    building[num]++; // 1개 건물 건설
                    if (building[num] == 1) { // 첫번째로 건설하면
                        for (int y: adj[num]) { // 건설 가능한 건물 갱신
                            indeg[y]--;
                        }
                    }
                } else {
                    ans = 0;
                    break;
                }
            } else { // cmd == 2, 1개의 건물을 파괴한다
                if (building[num] > 0) { // 건물이 1개 이상이면
                    building[num]--; // 건물을 파괴한다
                    if (building[num] == 0) { // 해당 건물이 0개이면
                        for (int y: adj[num]) { // 필요로 하는 건물에 조건 추가
                            indeg[y]++;
                        }
                    }
                } else {
                    ans = 0;
                    break;
                }
            }
        }
        System.out.println(ans == 1 ? "King-God-Emperor" : "Lier!");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
