import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, f;
    static HashMap<String, Long> board;
    static HashMap<String, Long> result;
    static long endTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정보의 개수
        String t = st.nextToken();
        long ed = Long.parseLong(t.substring(0, 3)); // 대여기간 일
        long em = calcuMinute(t.substring(4, 9)); // 대여기간 분
        endTime = ed * 1440 + em;
        f = Integer.parseInt(st.nextToken()); // 분당 요금
        board = new HashMap<>(); // 제품 대여 목록
        result = new HashMap<>(); // 벌금을 낼 사람의 목록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long day = calcuDay(st.nextToken()); // 일수
            long minute = calcuMinute(st.nextToken()); // 분
            String product = st.nextToken(); // 제품명
            String name = st.nextToken(); // 회원 닉네임
            String pinfo = product+name; // 제품 정보
            long time = day * 1440 + minute; // 정보의 분
            if (board.containsKey(pinfo)) { // 이전에 대여한 제품이면
                long duration = time - board.get(pinfo); // 대여 기간
                if (duration - endTime > 0) { // 반납 기간을 초과했으면
                    if (!result.containsKey(name)) { // 처음 기록하는 이름 이면
                        result.put(name, (duration - endTime) * f); // 새로 생성
                    } else {
                        result.put(name, result.get(name) + (duration - endTime) * f);
                    }
                }
                board.remove(pinfo); // 제품 대여 목록에서 삭제
            } else { // 대여할 제품이면
                board.put(pinfo, time); // 제품 대여 분 저장
            }
        }
        if (result.size() > 0) {
            ArrayList<People> results = new ArrayList<>();
            for (Map.Entry<String, Long> entrySet :result.entrySet()) {
                results.add(new People(entrySet.getKey(), entrySet.getValue()));
            }
            Collections.sort(results);
            for (int i = 0; i < results.size(); i++)
                sb.append(results.get(i).name).append(" ").append(results.get(i).pay).append("\n");
            System.out.print(sb.toString());
        } else {
            System.out.println(-1);
        }

    }

    static class People implements Comparable<People>{
        String name;
        long pay;

        public People(String name, long pay) {
            this.name = name;
            this.pay = pay;
        }

        @Override
        public int compareTo(People o) {
            return this.name.compareTo(o.name);
        }
    }

    static int calcuDay(String s) {
        // 2021-01-01 을 일로 바꿔준다, 2021년도 고정
        int month = Integer.parseInt(s.substring(5, 7));
        int day = 0;
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < month - 1; i++) {
            calendar.set(2021, i,1);
            day += calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        day += Integer.parseInt(s.substring(8, 10));
        return day;
    }

    static int calcuMinute(String s) {
        // 00:00 을 분으로 바꿔준다
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}
