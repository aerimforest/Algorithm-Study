import java.io.*;
import java.util.*;

public class 가운데에서_만나기 {
    static final int MAX = 1_000_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j) arr[i][j] = MAX;
            }
        }

        for(int i = 0; i < K; i++) {
            str = new StringTokenizer(br.readLine());
            int A = Integer.valueOf(str.nextToken());
            int B = Integer.valueOf(str.nextToken());
            int T = Integer.valueOf(str.nextToken());

            arr[A - 1][B - 1] = Math.min(arr[A - 1][B - 1], T);
        }


        int C = Integer.valueOf(br.readLine());
        int[] friend = new int[C];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            friend[i] = Integer.valueOf(str.nextToken()) - 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int[] max = new int[N];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < C; j++) {
                max[i] = Math.max(max[i], arr[friend[j]][i] + arr[i][friend[j]]);
            }
            min = Math.min(min, max[i]);
        }

        //최소값으로 갈 수 있는 도시 찾음.
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(min >= max[i]) result.add(i + 1);
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for(int c : result) {
            sb.append(c + " ");
        }
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
    }
}
