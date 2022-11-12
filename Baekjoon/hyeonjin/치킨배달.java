import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x;
        int y;
        Pair(int  x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int size;
    static int max;
    static char[][] city = new char[51][51];
    static Pair[] chicken = new Pair[14];
    static Pair[] house = new Pair[101];
    static boolean[] chickenCheck = new boolean[14];
    static int chickenNum = 0;
    static int houseNum = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        size = Integer.valueOf(str.nextToken());
        max = Integer.valueOf(str.nextToken());


        for(int i =1; i <= size; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= size; j++){
                city[i][j] = str.nextToken().charAt(0);
                if(city[i][j] == '1'){
                    houseNum++;
                    house[houseNum] = new Pair(i,j);
                }
                else if(city[i][j] == '2') {
                    chickenNum++;
                    chicken[chickenNum] = new Pair(i,j);
                }
            }
        }

        DFS(0,1);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    //치킨집중에 살아있는 만큼 생각하기
    private static void DFS(int depth, int index) {
        if(depth == max){
            //계산하는 루틴
            int total = 0;
            for(int i = 1; i <= houseNum; i++){
                int sum = Integer.MAX_VALUE;
                for(int j = 1; j <= chickenNum; j++){
                    if(chickenCheck[j])
                    {
                        int distance = Math.abs(house[i].x - chicken[j].x) + Math.abs(house[i].y - chicken[j].y);
                        sum = Math.min(distance, sum);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = index; i <= chickenNum; i++){
            if(chickenCheck[i]) continue;

            chickenCheck[i] = true;
            DFS(depth + 1, i + 1);
            chickenCheck[i] = false;
        }
    }
}
