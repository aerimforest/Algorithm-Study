import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
 
        int[] stationery = new int[N];
        int min = 50;
        int index = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            stationery[i] = temp-1;
 
            if (min >= stationery[i]) { // 일단 비용이 가장 작으면서 숫자는 큰 수를 찾는다.
                min = stationery[i];
                index = i;
            }
        }
 
        int money = Integer.parseInt(br.readLine());
        char[] digits = new char[51];
        int cnt = 0;
        while (money >= min) { // 비용이 가장 작으면서 숫자는 큰 수로 배열을 완성한다.
            digits[cnt++] = (char) (index + '0');
            money -= min;
        }
 
        int start = 0; // digits 배열에서 우리가 구하려는 답의 자릿수가 시작하는 위치.
        for (int i = 0; i < cnt; i++) {
            for (int j = N - 1; j >= 0; j--) {
                // 현재 돈에다가 min을 더한 값이 statinonery[j]보다 크다는 뜻은
                // 더 큰 숫자를 살 수 있다는 의미이다.
                if (stationery[j] <= money + min) {
                    digits[i] = (char) (j + '0');
                    money += min - stationery[j];
                    break;
                }
            }
 
            // digits[start]가 0이라는 뜻은
            // 현재 돈으로는 더 큰 숫자를 살 수 없다는 의미이다.
            // 따라서 자릿수를 1개 포기하고 min만큼의 돈을 다시 돌려 받는다.
            if (digits[start] == '0') {
                start++;
                money += min;
            }
        }
 
        // start와 cnt가 같다는 뜻은
        // digits 배열에서 cnt까지의 인덱스 값이
        // 모두 0이라는 의미이고, 이것은 0~N-1까지의 수 중에서
        // 오직 0만 구입할 수 있다는 것을 의미한다.
        if (start == cnt) {
            bw.write("0\n");
            bw.close();
            br.close();
            return;
        }
 
        String ans = "";
        for (int i = start; i < cnt; i++) {
            ans += digits[i];
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
