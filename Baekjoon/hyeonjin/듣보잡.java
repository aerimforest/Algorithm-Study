import java.io.*;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        Map<String, Boolean> map = new HashMap();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            map.put(br.readLine(), true);
        }

        for(int i = 0; i < M; i++){
            String s = br.readLine();
            boolean isExist = map.getOrDefault(s, false);
            if(isExist) result.add(s);
        }

        Collections.sort(result);

        bw.write(String.valueOf(result.size()));
        bw.newLine();
        for(int i = 0; i < result.size(); i++){
            bw.write(String.valueOf(result.get(i)));
            bw.newLine();
        }
        bw.flush();
    }
}
