import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] memo = new int[str1.length()+1][str2.length()+1]; // 해당 문자를 끝으로 하는 공통 문자열의 길이
        int ans = 0;
        for (int i = 0, index1 = 1; i < str1.length(); i++, index1++) { // 첫번째 문자열
            for (int j = 0, index2 = 1; j < str2.length(); j++, index2++) { // 두번째 문자열
                if (str1.charAt(i) == str2.charAt(j)) { // 두 문자가 일치하면
                    memo[index1][index2] = memo[index1-1][index2-1] + 1; // 이전 문자열 뒤에 문자 추가
                    ans = Math.max(ans, memo[index1][index2]); // 정답 갱신
                }
            }
        }
        System.out.println(ans);
    }
}
