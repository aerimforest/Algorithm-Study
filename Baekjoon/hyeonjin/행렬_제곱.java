import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.valueOf(str.nextToken());
        long square = Long.parseLong(str.nextToken());
        int[][] array = new int[num][num];
        int[][] result = new int[num][num];
        for(int i =0 ; i < num; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++){
                array[i][j] = Integer.valueOf(str.nextToken());
                if(i == j)
                    result[i][j] = 1;
            }
        }

        //square를 2의 거듭제곱으로 나눠보기
        long[] twoSquare = new long[50];
        long two = 1;
        int index = 0;

        while(square / two >= 1){
            two *= 2;
            index++;
        }

        for(int i = index; i >= 0; i--){
            twoSquare[i] = square / two;
            square %= two;
            two /= 2;
        }

        if(twoSquare[0] == 1){
            result = array;
        }

        for(int i = 1; i < index; i++){
            array = arrayMulti(array, array);
            for(int j =0; j < twoSquare[i]; j++){
                result = arrayMulti(result, array);
            }
        }

        for(int i =0; i < num; i++){
            for(int j = 0; j < num; j++){
                bw.write(String.valueOf(result[i][j] % 1000) + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }


    public static int[][] arrayMulti(int[][] arr1, int[][] arr2){
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < arr1.length ; ++i){
            for(int j = 0 ; j < arr2[0].length ; ++j){
                for(int k = 0 ; k < arr1[0].length ; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] %= 1000;
            }
        }

        return answer;
    }
}
