import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        long ans = 0;

        // 음수 -> 곱한게 최댓값
        for (; left < right; left +=2) {
            if (arr[left] < 1 && arr[left + 1] < 1) {
                ans += arr[left] * arr[left + 1];
            } else {
                break;
            }
        }

        // 양수
        for (; right > 0; right -=2) {
            if (arr[right] > 1 && arr[right - 1] > 1) {
                ans += arr[right] * arr[right - 1];
            } else {
                break;
            }
        }

        // 중간에 남은 것들.
        for (; right >= left; right --) {
            ans += arr[right];
        }
        System.out.println(ans);
    }

} 
