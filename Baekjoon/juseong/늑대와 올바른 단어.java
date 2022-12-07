import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    static char[] wolf = { 'w', 'o', 'l', 'f' };
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String input = br.readLine();
 
        System.out.println(process(input));
    }
 
    private static int process(String str) {
 
        char[] arr = new char[4];
        int[] cnt = new int[26];
        // 첫 문자는 먼저 넣어두자.
        char prev = str.charAt(0);
        arr[0] = str.charAt(0);
        cnt[str.charAt(0) - 'a']++;
        int idx = 1;
        
        for (int i = 1; i < str.length(); i++) {
            char now = str.charAt(i);
            // 이전 문자와 같다면 pass
            if(now == prev) {
                cnt[now - 'a']++;
                continue;
            }
            
            // 다르다면
            // 'w'로 다시 시작할 경우.
            if(idx == 4) {
                // 순서 및 반복횟수 확인
                if(!check(arr, cnt)) return 0;
                
                // cnt 배열과 index 초기화
                cnt = new int[26];
                idx = 0;
            }
            
            arr[idx++] = now;
            cnt[now - 'a']++;
            prev = now;
        }
 
        // 길이가 4인 경우도 확인 필요
        if(!check(arr, cnt)) return 0;
        
        return 1;
    }
 
    private static boolean check(char[] arr, int[] cnt) {
        
        int flag = cnt[arr[0] - 'a'];
        for (int ck = 0; ck < 4; ck++) {
            // 순서 확인
            if(arr[ck] != wolf[ck]) return false;
            // 반복횟수 확인
            if(cnt[arr[ck] - 'a'] != flag) return false;
        }
        
        return true;
    }
 
}
