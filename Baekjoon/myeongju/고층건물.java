import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] build = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            build[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];

        for (int i = 0; i < N-1; i++) {
            double max = (build[i+1]-build[i]);
            arr[i]++;
            arr[i+1]++;

            for (int j = i+2; j < N; j++) {
                double slope = (double) (build[j] - build[i]) / (j-i);

                if(slope > max) {
                    arr[i]++;
                    arr[j]++;
                    max = slope;
                }
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[N-1]);
    }
}