import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] wolf = {'w', 'o', 'l', 'f'};
        int index = 0;

        while(str.length() > index){
            if(str.charAt(index) != wolf[0]){
                System.out.println(0);
                return;
            }


            int num = 0;
            while(index + num < str.length() && str.charAt(index + num) == wolf[0]){
                num++;
                if(index + num >= str.length()){
                    System.out.println(0);
                    return;
                }
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < num; j++){
                    if(index >= str.length() || str.charAt(index) != wolf[i]){
                        System.out.println(0);
                        return;
                    }
                    index++;
                }
            }
        }
        System.out.println(1);
    }
}
