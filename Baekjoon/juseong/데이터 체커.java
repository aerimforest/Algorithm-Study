import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static PriorityQueue<Dot> pq;
    static boolean duple;

    static class Dot implements Comparable<Dot> {
        int no, x;

        public Dot(int no, int x) {
            this.no = no; // 원의 번호
            this.x = x; // x축 좌표
        }

        @Override
        public int compareTo(Dot o) {
            if (this.x == o.x) duple = true; // 임의의 두 원의 x좌표가 서로 만나면
            return this.x - o.x; // x좌표를 기준으로 오른차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<Dot>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new Dot(i, x - r)); // x축 시작점 추가
            pq.add(new Dot(i, x + r)); // x축 끝점 추가
        }
        if (duple) { // 임의의 두 원의 x좌표가 서로 만나면
            System.out.println("NO");
        } else {
            Stack<Integer> stack = new Stack<>(); // 원의 x축 좌표값을 관리
            while (!pq.isEmpty()) { // 모든 원의 x축 좌표값을 꺼낼때 까지
                if (stack.isEmpty()) { // 여기 까지 고려한 모든 원이 겹치지 않았을 떄
                    stack.add(pq.poll().no); // 원의 시작점 추가
                } else {
                    int no = pq.poll().no; // pq에 저장한 x좌표중 가장 작은 값을 꺼냄
                    if (stack.peek() == no) { // 해당 원의 시작점과 끝점이 같은 원이면
                        stack.pop(); // 해당 원의 시작점 제거
                    } else {
                        stack.add(no); // 원의 시작점 or 끝점 추가
                    }
                }
            }
            if (stack.isEmpty()) { // 모든 원이 겹치지 않았을 떄 ture
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
