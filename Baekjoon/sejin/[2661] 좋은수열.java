import java.io.*;
import java.util.*;

public class Main {

    static int N ;
    static String ans;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MakeArr("1");
	}

    public static void MakeArr(String str){
        if(str.length() == N ) {
            System.out.println(str);
            System.exit(0);
        }

        for(int i=1;i<4;i++){
            String next = String.valueOf(i);
            if(GoodArr(str + next)){
                MakeArr(str + next);
            }
        }
    }

    public static boolean GoodArr(String check){
        int CheckNum = check.length();
        for(int i=1;i<=CheckNum/2;i++){
            if(check.substring(CheckNum-i,CheckNum).equals(check.substring(CheckNum-2*i,CheckNum-i))) return false;
        }

        return true;
    }

}

