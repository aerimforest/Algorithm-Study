import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, V;
    static int[] vote;
    static int[] time;

    static class Candidate implements Comparable<Candidate> {
        int num, vote, time;

        public Candidate(int num, int vote, int time) {
            this.num = num;
            this.vote = vote;
            this.time = time;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.vote != o.vote) {
                return this.vote - o.vote;
            } else {
                return this.time - o.time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사진들의 개수 (1 <= N <= 20)
        V = Integer.parseInt(br.readLine()); // 전체 학생의 추천 수 (V <= 1000)
        vote = new int[101]; // 학생들의 번호 (1 <= k <= 100), k번쩨 학생의 투표수
        time = new int[101];// k번쩨 학생의 처음 투표 받은 시간
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            int student = Integer.parseInt(st.nextToken()); // 추천 학생 번호
            if (vote[student] > 0) { // 해당 학생의 사진이 개시되어 있으면
                vote[student]++;
            } else { // 해당 학생 사진을 넣을 자리가 없으면
                ArrayList<Candidate> candidates = new ArrayList<>();
                for (int j = 1; j < 101; j++) {
                    if (vote[j] > 0) {
                        candidates.add(new Candidate(j, vote[j], time[i]));
                    }
                }
                Collections.sort(candidates);
                Candidate remove = candidates.get(0);
                vote[remove.num] = 0;
                time[remove.num] = 0;
            }
        }
        for (int j = 1; j < 101; j++) {
            if (vote[j] > 0) {
                sb.append(j);
            }
        }
        System.out.println(sb.toString());
    }
}
