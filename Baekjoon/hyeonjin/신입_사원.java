import java.io.*;
import java.util.*;

public class 신입_사원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.valueOf(br.readLine());
            Applicant[] arr = new Applicant[N];

            for(int i = 0; i < N; i++){
                str = new StringTokenizer(br.readLine());
                arr[i] = new Applicant(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken()));
            }

            Arrays.sort(arr);

            int min = arr[0].interview;
            int count = N;
            for(int i = 1; i < N; i++){
                if(arr[i].interview < min) min = arr[i].interview;
                else count--;
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
    }

    public static class Applicant implements Comparable<Applicant>{
        int report;
        int interview;

        public Applicant(int report, int interview){
            this.report = report;
            this.interview = interview;
        }

        @Override
        public int compareTo(Applicant o){
            return report - o.report;
        }
    }
}
