import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.valueOf(br.readLine());
        int size = G / 2 == 1? (G + 1) / 2  + 1 : G / 2 + 1;

        int[] arr = new int[size];
        boolean[] check = new boolean[G + 1];
        for(int i = 1; i < size; i++){
            if(G % i == 0) arr[i] = G / i;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < size; i++){
            if(arr[i] != 0 && !check[i] && i != arr[i] && (i + arr[i]) % 2 == 0 ){
                check[arr[i]] = true;
                result.add(i + arr[i]);
            }
        }

        Collections.sort(result);
        if(result.size() == 0) bw.write("-1");
        else {
            for (int i = 0; i < result.size(); i++) {
                bw.write(String.valueOf(result.get(i) / 2));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
