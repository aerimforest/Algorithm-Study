import java.io.*;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        arr = new char[N][N];

        drawStar(0,0, N, false);

        for(int i = 0; i < N; i++){
            String str = "";
            for(int j = 0; j < N; j++){
                str += arr[i][j];
            }
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
    }

    private static void drawStar(int x, int y, int N, boolean isBlank) {
        if(isBlank){
            for(int i = x; i < x + N; i++){
                for(int j = y; j < y + N; j++){
                    arr[i][j] = ' ';
                }
            }

            return;
        }

        if(N == 1) {
            arr[x][y] = '*';
            return;
        }

        int n = N / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) drawStar(x + (n * i),y + (n * j), n, true);
                else drawStar(x +(n * i),y + (n * j), n ,false);
            }
        }
    }
}
