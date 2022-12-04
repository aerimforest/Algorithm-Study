import java.util.*;
import java.io.*;

public class Main {
    static String s;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {

            s = br.readLine();

            if(func(0,s.length()-1)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    public static boolean func(int start, int end) {

        if(start>= end) return true;

        int l = start;
        int r = end;

        while(l<r) {
            if(s.charAt(l++)==s.charAt(r--)) return false;
        }

        int mid = (start + end)/2;
        return func(start, mid-1) && func(mid+1, end);
    }
}