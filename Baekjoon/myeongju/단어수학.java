import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();

        while(N-->0) {
            String s = new StringBuilder(br.readLine()).reverse().toString();

            int n = 1;
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+n);
                n *= 10;
            }
        }

        ArrayList<Character> keys = new ArrayList<>(map.keySet());

        keys.sort((o1,o2)->map.get(o2)-map.get(o1));

        int answer = 0;
        int n = 9;

        for(Character key : keys) {
            answer += map.get(key) * n--;
        }

        System.out.println(answer);
    }
}