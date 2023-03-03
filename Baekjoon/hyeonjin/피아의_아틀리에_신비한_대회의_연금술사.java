import java.io.*;
import java.util.*;

public class 피아의_아틀리에_신비한_대회의_연금술사 {
    static int N;
    static int[][][][] value;
    static char[][][][] type;
    static boolean[] check;
    static int[][] arr;
    static char[][] arrType;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[5][5];
        arrType = new char[5][5];
        value = new int[N][4][4][4];
        type = new char[N][4][4][4];
        check = new boolean[N];

        for(int n = 0; n < N; n++){
            //value
            for(int i = 0; i < 4; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++){
                    value[n][0][i][j] = Integer.valueOf(str.nextToken());
                }
            }

            //type
            for(int i = 0; i < 4; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++){
                    type[n][0][i][j] = str.nextToken().charAt(0);
                }
            }

            for(int i = 1; i < 4; i++){
                rotate(n, i);
            }
        }


        dfs(0);

        System.out.println(max);
    }

    private static void rotate(int num, int index) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                value[num][index][i][j] = value[num][index - 1][3 - j][i];
                type[num][index][i][j] = type[num][index - 1][3 - j][i];
            }
        }


    }

    private static void dfs(int depth) {
        if(depth == 3){
            countQuality();
            return;
        }

        //재료
        for(int i = 0; i < N; i++){
            if(check[i]) continue;
            //회전
            for(int j = 0; j < 4; j++){
                //위치
                for(int x = 0; x <= 1; x++){
                    for(int y = 0; y <= 1; y++){
                        check[i] = true;
                        int[][] copy = deepCopy_int();
                        char[][] copy_type = deepCopy_char();
                        changeBomb(i,j,x,y);

                        dfs(depth + 1);

                        arr = copy;
                        arrType = copy_type;
                        check[i] = false;
                    }
                }
            }
        }
    }

    private static void countQuality() {
        int result = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arrType[i][j] == 'R') result += arr[i][j] * 7;
                else if(arrType[i][j] == 'B') result += arr[i][j] * 5;
                else if(arrType[i][j] == 'G') result += arr[i][j] * 3;
                else if(arrType[i][j] == 'Y') result += arr[i][j] * 2;
            }
        }

        max = Math.max(result, max);
    }

    private static void changeBomb(int n, int turn, int x, int y) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //효능
                arr[i + x][j + y] += value[n][turn][i][j];

                if(arr[i + x][j + y] > 9) arr[i + x][j + y] = 9;
                else if (arr[i + x][j + y] < 0) arr[i + x][j + y] = 0;

                //원소
                if(type[n][turn][i][j] != 'W') arrType[i + x][j + y] = type[n][turn][i][j];
            }
        }
    }

    private static int[][] deepCopy_int(){
        int[][] copy = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private static char[][] deepCopy_char(){
        char[][] copy = new char[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                copy[i][j] = arrType[i][j];
            }
        }
        return copy;
    }
}
