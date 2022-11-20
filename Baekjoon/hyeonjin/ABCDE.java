import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static boolean[] check;
    static List<Integer>[] friend;
    static boolean find;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        friend = new ArrayList[N];
        check = new boolean[N];

        for(int i = 0 ; i < N; i++){
            friend[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        for(int i = 0 ; i < N; i++){
            if(!find) {
                check[i] = true;
                findFriend(0, i);
                check[i] = false;
            }
        }

        if(find)
            bw.write("1");
        else
            bw.write("0");

        bw.flush();
    }

    private static void findFriend(int depth, int index) {
        if(depth == 4){
            find = true;
            return;
        }

        for(int f : friend[index]){
            if(!check[f] && !find){
                check[f] = true;
                findFriend(depth + 1, f);
                check[f] = false;
            }
        }
    }


}
