import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int ans = 0;
        for(int i = 0;i < n; i++) {
            int x = a[i];

            int s = 0, e = a.length - 1, sum = 0;
            while (s < e) { //시작 < 끝
                sum = a[s] + a[e];
                if (sum == x) { //'좋다'인 수 중에
                    if (i == s) //시작점이 현재 값일때 (cnt 안함)
                        s++;
                    else if (e == i) //끝점이 현재 값일때 (cnt 안함)
                        e--;
                    else {
                        ans++;
                        break;
                    }
                }
                if (a[s] + a[e] > x) // 값이 크면 작은 값으로 이동해서 값 맞춤
                    e--;
                else if (a[s] + a[e] < x) //값이 작으면 큰 값으로 이동해서 값 맞춤
                    s++;
            }
        }
        System.out.print(ans);

        bw.flush(); bw.close(); br.close();
    }
}
