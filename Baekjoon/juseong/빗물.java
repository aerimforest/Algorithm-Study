import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        A = new int[W+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 왼쪽부터 오른쪽으로 이동하면서 물을 채운다
        int ans = 0;
        for (int i = 1; i <= H; i++) {
            int start = 0; // 시작 높이
            if (A[1] >= i) { // 시작좌표가 비어 있지 않을 때
                start = A[1]; // 시작 높이 갱신
            }
            int water = 0; // 찾은 빛물
            int temp = 0; // 임시 및물
            for (int j = 2; j <= W; j++) { // 오른쪽으로 1칸씩 이동
                if (start == 0) { // 시작좌표가 비어 있을 때
                    if (A[j] == 0) continue; // 칸이 비어 있다면
                    start = A[j]; //비어 있지 않다면
                    continue;
                }
                if  (A[j] < start && A[j] < i) { // 해당 열 블록이 시작 높이보다 낮으면
                    temp++; // 빗물을 채운다
                } else { // 해당 열 블록이 시작 높이보다 크거나 같으면(부딪칠때)
                    water += temp; // 빗물 추가
                    temp = 0; // 빗물 초기화
                    start = A[j]; // 시작 높이 갱신
                }
            }
            ans += water;
        }
        System.out.println(ans);
    }
}
