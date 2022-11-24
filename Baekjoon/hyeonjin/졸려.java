import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.valueOf(br.readLine());
        String str = br.readLine();
        int size = str.length();
        List<String> check = new ArrayList<>();

        while(!check.contains(str) && check.size() <= num){
            check.add(str);
            String change = "";

            for(int i = 0; i < size; i += 2){
                change += str.charAt(i);
            }
            if(size % 2 == 0) {
                for (int j = size - 1; j >= 0; j -= 2) {
                    change += str.charAt(j);
                }
            }
            else{
                for(int j = size - 2; j >= 0; j -= 2){
                    change += str.charAt(j);
                }
            }

            str = change;
        }

        int selectNum = num % check.size();
        String result = check.get(selectNum);
        System.out.println(result);
    }
}
