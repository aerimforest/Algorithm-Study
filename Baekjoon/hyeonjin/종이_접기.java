import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());
        for(int t = 0; t < testCase; t++){
            String result = "NO";
            String s = br.readLine();

            if(check(s, 0, s.length() - 1))
                result = "YES";


            System.out.println(result);
        }

    }

    private static boolean check(String s, int start, int end) {
        if(start >= end) return true;

        int left = start;
        int right = end;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)) return false;
            left++;
            right--;
        }

        int mid = (start + end) / 2;
        return check(s, start, mid - 1) && check(s, mid + 1, end);

    }
}
