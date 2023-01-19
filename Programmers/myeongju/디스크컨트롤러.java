import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> queue = new PriorityQueue<>();
        PriorityQueue<Job> list = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.work - o2.work;
            }
        });

        for(int[] arr : jobs)
            queue.add(new Job(arr[0],arr[1]));
        
        int time = 0;
        while(true) {
            
            if(list.isEmpty()) {
                if(queue.isEmpty()) break;
                else list.add(queue.poll());
            }
            
            Job now = list.poll();
            
            // 현재 작업이 시작하기 까지 대기한 시간을 더해준다.
            if(time > now.start)
                answer += time - now.start;
            else time = now.start;
            
            // 작업 시간을 더해준다.
            time += now.work;
            answer += now.work;
            
            while(!queue.isEmpty() && queue.peek().start <= time)
                list.add(queue.poll());
        }
        
        return answer/jobs.length;
    }
    
    public class Job implements Comparable<Job> {
        int start;
        int work;
        
        public Job(int start, int work) {
            this.start = start;
            this.work = work;
        }
        
        // 요청 시간 오름차순 -> 작업 시간 오름차순
        @Override
        public int compareTo(Job o) {
            if(this.start==o.start) 
                return this.work-o.work;
            else return this.start-o.start;
        }
    }
}