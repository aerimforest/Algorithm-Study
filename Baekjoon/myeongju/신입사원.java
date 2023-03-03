import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Person> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            list.sort((o1, o2) -> o1.score - o2.score);

            int answer = 1;
            int min = list.get(0).rank;
            for (int i = 1; i < N; i++) {
                if (list.get(i).rank < min) {
                    answer++;
                    min = list.get(i).rank;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static class Person {
        int score;
        int rank;

        public Person(int score, int rank) {
            this.score = score;
            this.rank = rank;
        }
    }
}
