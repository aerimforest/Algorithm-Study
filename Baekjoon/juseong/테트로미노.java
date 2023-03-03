import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] A;
    static int[][][] block = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // 0
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // 1
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 2
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // 3
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // 4
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // 5
            {{0, 0}, {1, -2}, {1, -1}, {1, 0}}, // 6
            {{0, 0}, {0, 1}, {-1, 1}, {-2, 1}}, // 7
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // 8
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}}, // 9
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // 10
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 11
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}, // 12
            {{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}}, // 13
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // 14
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // 15
            {{0, 0}, {-1, 1}, {0, 1}, {1, 1}}, // 16
            {{0, 0}, {-1, 1}, {0, 1}, {0, 2}}, // 17
            {{0, 0}, {-1, 0}, {0, 1}, {1, 0}} // 18
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로, (4 ≤ N, M ≤ 500)
        M = Integer.parseInt(st.nextToken()); // 가로
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) { // 세로
            for (int j = 0; j < M; j++) { // 가로
                for (int k = 0; k < 19; k++) { // 모든 블록
                    boolean found = true; // 블록을 넣을 수 있으면
                    int sum = 0; // 블록에 놓인 수들의 합
                    for (int kk = 0; kk < 4; kk++) { // 블록의 칸
                        int x = i + block[k][kk][0], y = j + block[k][kk][1];
                        if (x < 0 || y < 0 || x >= N || y >= M) {
                            found = false;
                            break;
                        }
                        sum += A[x][y];
                    }
                    if (found) ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }
}
