import java.util.*;
import java.io.*;

/*
추천 가장 적은 학생 삭제 (두명일 경우 오래된 사진 삭제)
삭제 될 때 추천 횟수 0으로 초기화

학생 <= 100
추천 <= 1000

고려사항 : 순서, 추천 횟수

N 만큼의 사진틀에 사람 넣기.
꽉 차면
방금 추천 받은 사람의 추천 수 vs 사진틀에서 가장 추천 적은 추천 수 비교
바꿔야 한다면 체인지

 */
public class Main {
    static int N;
    static int[] rec = new int[101];
    static int[] order = new int[101];
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>((o1, o2) -> {
            if (rec[o1] != rec[o2]) return rec[o1] - rec[o2];
            else return order[o1] - order[o2];
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= t; i++) {
            int num = Integer.parseInt(st.nextToken());

            rec[num]++;

            // 이미 들어가있는 학생이라면 건너뛰기
            if(order[num]!=0) {
                queue.remove(num);
                queue.add(num);
                continue;
            }

            // 사진틀이 남아있다면 추가하기
            if(queue.size() < N) {
                order[num] = i;
                queue.add(num);
            }
            else {
                int out = queue.poll();
                rec[out] = order[out] = 0;

                order[num] = i;
                queue.add(num);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 101; i++) {
            if(order[i]!=0)
                sb.append(i+" ");
        }
        System.out.print(sb);
    }
}
