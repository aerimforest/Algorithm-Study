import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());
        ArrayList<Integer>[] building = new ArrayList[N + 1];
        int[] countBuild = new int[N + 1];
        int[] built = new int[N + 1];

        for(int i = 0; i <= N; i++){
            building[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            building[x].add(y);
            countBuild[y]++;
        }

        boolean end = false;
        for(int i = 0; i < K; i++){
            str = new StringTokenizer(br.readLine());
            int isBuild = Integer.valueOf(str.nextToken());
            int target = Integer.valueOf(str.nextToken());

            if(end) continue;


            if(isBuild == 1){
                built[target]++;

                if(countBuild[target] != 0)
                    end = true;

                if(built[target] > 1) continue;
                for(int j = 0; j < building[target].size(); j++){
                    countBuild[building[target].get(j)]--;
                }
            }
            else{
                built[target]--;

                if(built[target] < 0)
                    end = true;

                if(built[target] > 0) continue;
                for(int j = 0; j < building[target].size(); j++){
                    countBuild[building[target].get(j)]++;
                }
            }
        }

        if(end)
            System.out.println("Lier!");
        else
            System.out.println("King-God-Emperor");
    }
}
