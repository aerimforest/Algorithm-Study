import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans;
    static int[] vocaList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 5;
        vocaList = new int[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int voca = 0; // 단어에 포함된 알파벳을 이진수으로 변환하여 저장
            for (int j = 0; j < s.length(); j++) {
                char c =  s.charAt(j);
                voca |= (1 << (s.charAt(j) - 'a'));
            }
            vocaList[i] = voca;
        }
        // end of input

        int start = 0; // 필수 알파벳 (a, c, i, n, t)
        start |= (1 << ('a' - 'a')); // 'a' 학습
        start |= (1 << ('c' - 'a')); // 'c' 학습
        start |= (1 << ('i' - 'a')); // 'i' 학습
        start |= (1 << ('n' - 'a')); // 'n' 학습
        start |= (1 << ('t' - 'a')); // 't' 학습
        if (k >= 0) { // 배우는 단어의 개수가 5개 이상일때
            rec_func(0, 0, start); // 조합으로 알파벳 선택
        }
        System.out.println(ans);
    }

    static void rec_func(int index, int n, int result) {
        if (n == k) { // k개의 알파벳을 배웠을 때
            int sum = 0; // 읽은 수 있는 단어의 개수
            for (int i = 0; i < vocaList.length; i++) { // 단어
                if ((vocaList[i] & result) == vocaList[i]) sum++;
            }
            ans = Math.max(ans, sum); //정답 갱신
            return;
        }
        if (index == 26) return; // 알파벳 범위를 벗어나면
        int alpha = 1 << index; // 알파벳 계산
        if ((result & alpha) == 0){ // 배우지 않은 알파벳 이면
            rec_func(index + 1, n + 1, result | alpha); // 해당 알파벳 학습
        }
        rec_func(index + 1, n, result); // 해당 알파벳 학습 안함
    }
}
