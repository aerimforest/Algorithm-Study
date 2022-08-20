import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 백준(17609) - 회문(https://www.acmicpc.net/problem/17609)
     */
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        //자체회문: 0, 유사회문: 1, 그 외: 2
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr = reader.readLine().toCharArray();

            //1. 자체회문인지 확인
            if (checkPalindrome(0, arr.length - 1)) {
                sb.append("0").append("\n");
                continue;
            }

            //2. 유사회문인지 확인
            if ((checkSimilarPalindrome(0, arr.length - 1))) {
                sb.append("1").append("\n");
                continue;
            }

            //3. 암것도 아니면 2
            sb.append("2").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkSimilarPalindrome(int left, int right) {
        while (left <= right) {
            if (arr[left] != arr[right]) {
                //다른 문자가 나왔을때 그 안에 해당하는 문자열 팰린드롬 확인
                boolean tempLeft = checkPalindrome(left + 1, right);
                boolean tempRight = checkPalindrome(left, right - 1);

                if (!tempLeft && !tempRight) {
                    return false;
                } else {
                    return true;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkPalindrome(int left, int right) {
        while (left <= right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        return true;
    }
}
