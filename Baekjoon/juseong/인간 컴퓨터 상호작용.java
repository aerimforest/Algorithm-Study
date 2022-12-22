import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    private static final int ALPHABET_NUM = 26;
    private static List<Integer>[] alpAccLocation = new ArrayList[ALPHABET_NUM];

    private static void setAlpLocation(String input){
        for (int i = 0; i < ALPHABET_NUM; i++){
            int count = 0;
            alpAccLocation[i] = new ArrayList<Integer>();
            alpAccLocation[i].add(count);
            for (int j = 0; j < input.length(); j++) {
                if ((char)(i + 97) == input.charAt(j)){
                    count++;
                }
                alpAccLocation[i].add(count);
            }
        }
    }

    private static int getAlpRepeat(char prob, int start, int end){
        return alpAccLocation[(int)prob - 97].get(end + 1) - alpAccLocation[(int)prob - 97].get(start);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        setAlpLocation(br.readLine());
        int probNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < probNum; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(getAlpRepeat(st.nextToken().charAt(0),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
                    .append('\n');
        }
        System.out.println(sb);
    }
}
