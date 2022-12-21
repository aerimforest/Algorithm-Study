import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[][] total;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        String s = br.readLine();
        total = new int[26][s.length()];
        total[s.charAt(0) - 'a'][0] = 1;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = 0; j < 26; j++){
                total[j][i] = total[j][i - 1];
                if(j == (c - 'a')) total[j][i]++;
            }
        }

        int N = Integer.valueOf(br.readLine());
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            char c = str.nextToken().charAt(0);
            int left = Integer.valueOf(str.nextToken());
            int right = Integer.valueOf(str.nextToken());

            int rightValue = total[c - 'a'][right];
            int leftValue = left == 0 ? 0 : total[c - 'a'][left - 1];

            bw.write(String.valueOf(rightValue - leftValue));
            bw.newLine();
        }
        bw.flush();
    }
}
