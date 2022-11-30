import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean result;
    static int[] team1;
    static int[] team2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[6][3];

        setTeam();


        for(int t = 0; t < 4; t++){
            result = false;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    arr[i][j] = Integer.valueOf(str.nextToken());
                    sum += arr[i][j];
                }
            }

            if(sum == 30)
                dfs(0);

            if(result)
                bw.write("1 ");
            else
                bw.write("0 ");
        }
        bw.flush();
    }

    private static void setTeam() {
        int index = 0;
        team1 = new int[15];
        team2 = new int[15];

        for(int i = 0; i < 5; i++){
            for(int j = i + 1; j < 6; j++){
                team1[index] = i;
                team2[index] = j;
                index++;
            }
        }
    }


    private static void dfs(int depth){
        if(result) return;

        if(depth == 15){
            result = true;
            return;
        }

        for(int k = 0; k < 3; k++){
            int a = arr[team1[depth]][k];
            int b = arr[team2[depth]][2-k];
            if(a > 0 && b > 0){
                arr[team1[depth]][k]--;
                arr[team2[depth]][2-k]--;
                dfs(depth + 1);
                arr[team1[depth]][k]++;
                arr[team2[depth]][2-k]++;
            }
        }
    }
}
