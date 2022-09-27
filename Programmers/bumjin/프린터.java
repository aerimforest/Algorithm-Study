package Programmers.bumjin;

import java.util.*;

class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Printer> q = new LinkedList();

        for (int i=0; i<priorities.length; i++) {
            q.add(new Printer(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            int priority = q.peek().priority;
            boolean flag = false;

            for (Printer p : q) {
                if (p.priority > priority) {
                    //중요도 높은 문서 존재
                    flag = true;
                }
            }

            if (flag) {
                q.add(q.poll());
            } else {
                if (q.poll().location == location) {
                    //대기목록 길이 - q 길이
                    //q poll()로 계속 작아짐
                    answer = priorities.length - q.size();
                }
            }
        }

        return answer;
    }

    static class Printer {
        int location, priority;

        Printer(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
