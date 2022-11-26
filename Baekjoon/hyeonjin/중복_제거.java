import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        BitSet set = new BitSet(33554432);
        StringBuilder sb = new StringBuilder();

        int count = str.countTokens();
        for(int i =0; i < count; i++){
            int num = Integer.parseInt(str.nextToken());
            if(set.get(num))
                continue;

            set.set(num);
            sb.append(num);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
