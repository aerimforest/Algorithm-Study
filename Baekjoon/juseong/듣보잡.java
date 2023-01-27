import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static HashSet<String> ht = new HashSet<>();
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) { // 듣도 못한 사람
            ht.add(br.readLine()); // 듣도 못한 집합에 추가
        }
        for (int i = 0; i < M; i++) { // 보도 못한 사람
            String name = br.readLine(); // 보도 못한 사람
            if (ht.contains(name)) ans.add(name); // 듣보잡이면
        }
        Collections.sort(ans); // 사전순으로 정럴
        sb.append(ans.size()).append("\n"); // 듣보잡의 수
        for (String name: ans) sb.append(name).append("\n"); // 듣보잡의 이름 출력
        System.out.print(sb.toString());
    }
}
