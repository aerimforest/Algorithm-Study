import java.io.*;

public class 사탕_게임 {
    static int N;
    static char[][] arr;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                //오른쪽과 변경하기
                if(j + 1 < N) {
                    swap(i, j, i, j + 1);
                    countRow(i);
                    countCol(j);
                    countCol(j + 1);
                    //원위치로
                    swap(i, j, i, j + 1);
                }

                //아래랑 변경하기
                if(i + 1 < N) {
                    swap(i, j, i + 1, j);
                    countRow(i);
                    countRow(i + 1);
                    countCol(j);
                    //원위치로
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void countCol(int j) {
        int cnt = 1;
        char preChar = arr[0][j];
        for(int i = 1; i < N; i++){
            if(preChar == arr[i][j]){
                cnt++;
            }
            else{
                cnt = 1;
                preChar = arr[i][j];
            }
            max = Math.max(max, cnt);
        }
    }

    private static void countRow(int i) {
        int cnt = 1;
        char preChar = arr[i][0];
        for(int j = 1; j < N; j++){
            if(preChar == arr[i][j]){
                cnt++;
            }
            else{
                cnt = 1;
                preChar = arr[i][j];
            }
            max = Math.max(max, cnt);
        }
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
