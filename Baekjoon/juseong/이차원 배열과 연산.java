import java.util.*;
import java.io.*;

class Main {
    static class Pair implements Comparable<Pair> {
        int number;
        int count;

        Pair(int n, int c) {
            this.number = n;
            this.count = c;
        }

        // count 가 작은 게 앞으로, 같으면 number 가 작은게 앞으로
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
        }
    }

    static int r, c, k;
    static int[][] A = new int[101][101];
    static int xLength = 3, yLength = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1 ; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        System.out.println(solution());
    }

    static int solution() {
        for (int time = 0; time <= 100; time++) {
            if (A[r][c] == k) {
                return time;
            }
            operating();
        }

        return -1;
    }

    // R 연산 : 배열 A의 모든 행에 대해서 정렬을 수행한다
    // C 연산 : 배열 A의 모든 열에 대해서 정렬을 수행한다
    static void operating() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                R(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                C(i);
            }
        }
    }

    // 각 숫자들의 개수를 구해서 HashMap 에 담았다가 우선순위 큐에 옮겨담아서 정렬
    static void R(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>

        for (int i = 1; i <= yLength; i++) {
            if (A[key][i] == 0) continue;
            map.compute(A[key][i], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            A[key][i++] = p.number;
            A[key][i++] = p.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            A[key][i++] = 0; 
            A[key][i++] = 0; 
        }
    }
    
    // 각 숫자들의 개수를 구해서 HashMap 에 담았다가 우선순위 큐에 옮겨담아서 정렬
    static void C(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>

        for (int i = 1; i <= xLength; i++) {
            if (A[i][key] == 0) continue;
            map.compute(A[i][key], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            A[i++][key] = p.number;
            A[i++][key] = p.count;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99) {
            A[i++][key] = 0; 
            A[i++][key] = 0; 
        }
    }
}
