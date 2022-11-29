import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int frogNum;
    static int bridge;
    static int[][] interest;
    static int[][] likeLotus;
    static int[][] connect;
    static int[] checkLotus;
    static boolean end;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        frogNum = Integer.valueOf(str.nextToken());
        bridge = Integer.valueOf(str.nextToken());
        interest = new int[frogNum + 1][4];
        likeLotus = new int[frogNum + 1][2];
        checkLotus = new int[frogNum + 1];
        connect = new int[frogNum + 1][frogNum + 1];

        //interest
        for(int i = 1; i <= frogNum; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                interest[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        //likeLotus
        for(int i = 1; i <= frogNum; i++){
            str = new StringTokenizer(br.readLine());
            likeLotus[i][0] = Integer.valueOf(str.nextToken());
            likeLotus[i][1] = Integer.valueOf(str.nextToken());
        }

        //connect
        for(int i = 0; i < bridge; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            if(x > y){
                int tmp = x;
                x = y;
                y = tmp;
            }
            connect[x][y] = Integer.valueOf(str.nextToken());
        }

        dfs(0);

        if(!end)
            System.out.println("NO");
    }

    private static void dfs(int depth) {
        if(end)
            return;

        if(depth == frogNum){
            checkCommunication();
        }

        for(int i = depth + 1; i <= frogNum; i++){
            existLotus(likeLotus[i][0], i, depth);
            existLotus(likeLotus[i][1], i, depth);
        }
    }

    private static void checkCommunication() {
        for(int i = 1; i <= frogNum; i++){
            for(int j = 1; j <= frogNum; j++){
                int communication = connect[i][j];
                if(communication > 0){
                    if(interest[i][communication - 1] != interest[j][communication - 1])
                        return;
                }
            }
        }
        end = true;

        String result = "";
        for(int i = 1; i <= frogNum; i++){
            result += checkLotus[i] + " ";
        }

        System.out.println("YES");
        System.out.println(result);
    }

    private static void existLotus(int num, int index, int depth){
        if(checkLotus[num] != 0)
            return;

        checkLotus[num] = index;
        dfs(depth + 1);
        checkLotus[num] = 0;
    }
}
