import java.util.*;
import java.io.*;

/*
2를 곱한다
1을 오른쪽에 추가한다.
<= 1,000,000,000
 */
public class Main {
    static int ans = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        func(a,b,1);
        System.out.print(ans);
    }

    public static void func(int a,int b,int cnt) {
        if(a==b) {
            ans = cnt;
            return;
        }

        if(a*2<=b) func(a*2,b,cnt+1);
        if((a*10L+1) <= b) func((a*10+1),b,cnt+1);
    }
}