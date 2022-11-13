import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[] word;
    static boolean[] check;
    static int size;
    static int num;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        size = Integer.valueOf(st.nextToken());
        num = Integer.valueOf(st.nextToken());
        word = new String[num];
        check = new boolean[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            word[i] = st.nextToken();
        }
        Arrays.sort(word);
        DFS(0,0,"");
        bw.flush();
    }

    private static void DFS(int depth, int index, String str) throws IOException {
        if(depth == size){
            int vowelCount = 0;

            for(int i =0; i < size; i++){
                char c = str.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowelCount++;
            }

            if(vowelCount < 1)
                return;

            if(size - vowelCount < 2)
                return;

            bw.write(str);
            bw.newLine();
            return;
        }

        for(int i = index; i < num; i++){
            if(check[i]) continue;

            check[i] = true;
            DFS(depth + 1, i + 1, str + word[i]);
            check[i] = false;
        }

    }
}

