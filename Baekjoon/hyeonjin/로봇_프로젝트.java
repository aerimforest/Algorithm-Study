import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;
        while((str = br.readLine()) != null) {
            int x = Integer.parseInt(str);
            int n = Integer.valueOf(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(br.readLine());
            }

            Arrays.sort(arr);
            int start = 0;
            int end = n - 1;
            String result = "danger";
            x *= 10_000_000;
            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == x) {
                    result = "yes" + " " + arr[start] + " " + arr[end];
                    break;
                } else if (sum > x) {
                    end--;
                } else {
                    start++;
                }
            }

            System.out.println(result);
            str = null;
        }
    }
}
