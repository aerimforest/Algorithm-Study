import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] set_num;
    static int n, m;
    static LinkedList<HashSet<Integer>> set_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        set_num = new int[n + 1];
        Arrays.fill(set_num, -1);
        set_list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int a_num = set_num[a];
            int b_num = set_num[b];
            if (cmd == 0) {// 0: 합집합인 경우
                if (a_num < 0 && b_num < 0) { // 두 숫자 모두 포함하는 집합이 없을 때
                    HashSet<Integer> set = new HashSet<>();
                    set.add(a);
                    set.add(b);
                    set_list.add(set);
                    set_num[a] = set_list.size() - 1;
                    set_num[b] = set_list.size() - 1;
                } else if (a_num >= 0 && b_num >= 0) { // 두 숫자 모두 포함하는 집합이 있을 때
                    if (a_num == b_num) continue;
                    if (set_list.get(a_num).size() < set_list.get(b_num).size()) { // b 집합에 a 집합을 합칠 때
                        for (int num: set_list.get(a_num)) {
                            set_list.get(b_num).add(num);
                            set_num[num] = b_num;
                        }
                    } else {
                        for (int num: set_list.get(b_num)) { // a 집합에 b 집합을 합칠 때
                            set_list.get(a_num).add(num);
                            set_num[num] = a_num;
                        }
                    }
                } else if (a_num >= 0 && b_num < 0) { // 첫 번째 숫자만 포함하는 집합이 있을 때
                    set_list.get(a_num).add(b);
                    set_num[b] = a_num;
                } else if (a_num < 0 && b_num >= 0) { // 두 번째 숫자만 포함하는 집합이 있을 때
                    set_list.get(b_num).add(a);
                    set_num[a] = b_num;
                }
            } else if (cmd == 1) { // 1: 두 숫자가 같은 집합에 있는지 확인
                if (a_num >=0 && b_num >= 0 && a_num == b_num) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}
