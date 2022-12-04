import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //(ay-by)/(ax-bx) ? (ay-cy)/(ax-cx)
    //(ay-by)(ax-cx) ? (ay-cy)(ax-bx)
    // -axby + cxby -cxay + axcy + bxay -bxcy
    //(axcy + bxay + cxby) - (axby+bxcy+cxay)

    static int N;
    static long[] map;
    static int[] cache;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new long[N];
        cache = new int[N];

        for(int i=0; i<N; i++){
            map[i] = Long.parseLong(st.nextToken());
        }

        right();

        for (int a : cache){
            answer = Math.max(a, answer);
        }
        System.out.println(answer);
    }

    public static void right(){

        boolean cont;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                cont = true;
                for(int k=i+1; k<j; k++){
                    if(check(i,j,k) <= 0){
                        cont = false;
                        break;
                    }
                }
                if(cont){
                    cache[i]++;
                    cache[j]++;
                }
            }
        }
    }

    //음수면 기울기 커짐
    static long check(int a, int b, int c){
        return  (long)a*map[c] + (long)b*map[a] + (long)c*map[b] - ((long)a*map[b] + (long)b*map[c] + (long)c*map[a]);
    }
}
