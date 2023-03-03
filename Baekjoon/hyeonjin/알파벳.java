import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳
{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[] alphabet = new boolean[26];
    static boolean[][] check;
    static char[][] arr;
    static int R;
    static int C;
    static int max = 0;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());

        R = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());

        arr = new char[R][C];
        check = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        check[0][0] = true;
        alphabet[arr[0][0] - 'A'] = true;
        startTrip(1, 0, 0);
        alphabet[arr[0][0] - 'A'] = false;

        System.out.println(max);
    }

    private static void startTrip(int depth, int r, int c) {
        for(int k = 0; k < 4; k++){
            int x = r + dx[k];
            int y = c + dy[k];

            if(x < 0 || x >= R || y < 0 || y >= C || check[x][y] || alphabet[arr[x][y] - 'A']) continue;

            check[x][y] = true;
            alphabet[arr[x][y] - 'A'] = true;
            startTrip(depth + 1, x, y);
            alphabet[arr[x][y] - 'A'] = false;
            check[x][y] = false;
        }

        max = Math.max(depth, max);
    }
}
