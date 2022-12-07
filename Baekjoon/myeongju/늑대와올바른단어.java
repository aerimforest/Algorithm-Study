import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if (func(s)) System.out.println(1);
        else System.out.println(0);

    }

    public static boolean func(String s) {
        char[] arr = {'w', 'o', 'l', 'f'};

        int n = 0;
        int cnt = 0;
        int idx = 0;

        if( s.charAt(0) != arr[0]) return false;

        for (char c : s.toCharArray()) {
            if (c == arr[idx]) cnt++;
            else {

                if (idx == 0) n = cnt;

                idx = (idx + 1) % 4;

                if (c != arr[idx] || n != cnt) return false;

                cnt = 1;
            }
        }

        return idx == 3 && n==cnt;
    }
}