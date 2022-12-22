import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k;
    static int[] pay, parent, mins;

    // union-find 방법을 사용하여 집합을 만든다
    // 각 집합의 최소 비용은 집합의 친구비중 가장 적은 값이다
    // 각 집합의 최소 바용을 모두 더한다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 친구관계 수
        k = Integer.parseInt(st.nextToken()); // 가지고 있는 돈
        pay = new int[N+1]; // k번째 힉생의 친구비
        parent = new int[N+1]; // k번째 학생의 친구(부모)
        mins = new int[N+1]; // k번째 학생이 속해있는 집입의 최소 친구비
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pay[i] = Integer.parseInt(st.nextToken()); // 학생별 친구비
            mins[i] = pay[i];
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(pay[a], pay[b]);
            union(a, b, min); // a 와 b 를 같은 집합에 추가
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) { // 루트이면
                sum += mins[i]; // 집힙의 최소 비용 추가
            }
        }
        System.out.println(sum <= k ? sum : "Oh no");
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y, int min) {
        x = find(x); // x 의 루트
        y = find(y); // y 의 루트
        if (x != y) { // x, y의 루트가 다르면
            parent[y] = x; // y를 x 집합에 추가
            // x 집합의 최소 비용 갱신
            int min2 = Math.min(mins[x], mins[y]); // 기존 x, y 집합의 최소 비용
            mins[x] = Math.min(min2, min); // 기존 집합의 최소 비용와 새로운 값의 최소 비용
        }
    }
}
