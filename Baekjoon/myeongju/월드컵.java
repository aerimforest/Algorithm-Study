import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static boolean flag;
    static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[6][3];
        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flag = false;
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++)
                    sum += arr[i][j] = Integer.parseInt(st.nextToken());
            }
            if(sum==30) dfs(0);
            if (flag) sb.append(1 + " ");
            else sb.append(0 + " ");
        }

        System.out.println(sb);
    }

    public static void dfs(int cnt) {

        if (flag) return;

        if (cnt == 15) {
            flag = true;
            return;
        }

        int t1 = team1[cnt];
        int t2 = team2[cnt];

        if (arr[t1][0] > 0 && arr[t2][2] > 0) {
            arr[t1][0]--;
            arr[t2][2]--;
            dfs(cnt + 1);
            arr[t1][0]++;
            arr[t2][2]++;
        }

        if (arr[t1][1] > 0 && arr[t2][1] > 0) {
            arr[t1][1]--;
            arr[t2][1]--;
            dfs(cnt + 1);
            arr[t1][1]++;
            arr[t2][1]++;
        }

        if (arr[t1][2] > 0 && arr[t2][0] > 0) {
            arr[t1][2]--;
            arr[t2][0]--;
            dfs(cnt + 1);
            arr[t1][2]++;
            arr[t2][0]++;
        }
    }
}