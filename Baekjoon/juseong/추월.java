import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int n, ans;
    static HashMap<String, Integer> ht;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ht = new HashMap<>();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            String num = br.readLine();
            ht.put(num, i);
        }
        for (int i = 1; i <= n; i++) {
            String num = br.readLine();
            arr[i] = ht.get(num);
        }
        for (int i = 1; i < n; i++) { // 현재
            for (int j = i + 1; j <= n; j++) { // 다음
                if (arr[j] < arr[i]) { // 현재보다 먼저 들어간 차기 있으면
                    ans++;
                    break;
                }
            }

        }
        System.out.println(ans);
    }
}
