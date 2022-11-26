package SolveAc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;

public class sa2064 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(br.readLine());
        boolean[][][] arr = new boolean[num][4][8];

        for(int i = 0; i < num; i++){
            String input = br.readLine();
            String[] str = input.split("[.]");

            for(int j = 0; j < 4; j++){
                String binary = Integer.toBinaryString(Integer.valueOf(str[j]));
                int length = binary.length();
                for(int k = 7; k >=0; k--){
                    arr[i][j][k] = length > 0 && binary.charAt(length - 1) == '1'? true : false;
                    length--;
                }
            }
        }

        boolean[][] checkDiff = new boolean[4][8];
        boolean[][] selected = arr[0];


        for(int i = 1; i < num; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 8; k++){
                    if(selected[j][k] != arr[i][j][k])
                        checkDiff[j][k] = true;
                }
            }
        }

        boolean stop = false;
        boolean[][] mask = new boolean[4][8];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 8; j++){
                if(checkDiff[i][j]) {
                    for(int b = j; b < 8; b++){
                        selected[i][b] = false;
                    }

                    for(int a = i + 1; a < 4; a++){
                        for(int b = 0; b < 8; b++){
                            selected[a][b] = false;
                        }
                    }
                    stop = true;
                    break;
                }

                mask[i][j] = true;
            }
            if(stop)
                break;
        }

        String str1 = printIP(selected);
        String str2 = printIP(mask);

        System.out.println(str1);
        System.out.println(str2);
    }

    private static String printIP(boolean[][] selected) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            String str = "";
            for(int j = 0; j < 8; j++){
                str += selected[i][j] ? "1" : "0";
            }
            int integer = Integer.parseInt(str,2);
            result.add(String.valueOf(integer));
        }
        return String.join(".", result);
    }
}
