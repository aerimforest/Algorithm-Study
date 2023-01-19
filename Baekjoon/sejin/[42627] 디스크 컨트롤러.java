import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public int solution(int[][] jobs) {

		int answer = 0;
		int end = 0; // 수행되고난 직후의 시간
		int jobsIdx = 0; // jobs 배열의 인덱스
		int count = 0; // 수행된 요청 개수

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청시간 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 처리 시간 정렬

		while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]);
			}

			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0];

			// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			} else {
				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
	}
}
