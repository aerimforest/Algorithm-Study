package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1300_K번쨰수 {
	static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            // mid보다 작은 수의 개수를 구한다.
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}