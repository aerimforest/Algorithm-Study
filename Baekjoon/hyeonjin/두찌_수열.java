import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[][] check;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int test_case = Integer.valueOf(br.readLine());
        for(int t = 0; t < test_case; t++){
            N = Integer.valueOf(br.readLine());
            check = new int[1001][N];
            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                check[0][i] = Integer.valueOf(str.nextToken());
            }

            boolean isAllZero = false;
            boolean isLoop = false;
            int index = 1;
            while(!isAllZero && !isLoop){
                for(int i = 0; i < N; i++){
                    check[index][i] = Math.abs(check[index - 1][i] - check[index - 1][(i + 1) % N]);
                }

                //check Zero
                isAllZero = checkZero(index);
                isLoop = checkLoop(index);
                index++;
            }

            if(isAllZero) System.out.println("ZERO");
            else if(isLoop) System.out.println("LOOP");
        }
    }

    private static boolean checkLoop(int index) {
        for(int i = 0; i < index; i++){
            boolean isLoop = true;
            for(int j = 0; j < N; j++){
                if(check[index][j] != check[i][j]) {
                    isLoop = false;
                    break;
                };
            }
            if(isLoop) return true;
        }

        return false;
    }

    private static boolean checkZero(int index) {
        for(int i = 0; i < N; i++){
            if(check[index][i] != 0) return false;
        }

        return true;
    }
}
