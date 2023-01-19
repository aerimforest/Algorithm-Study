import heapq
from collections import deque

def solution(jobs):
    ans, now, st = 0, 0, -1
    pq = []
    jobs = list(sorted(jobs, key= lambda k : k[0]))
    jobs = deque(jobs)
    tot = len(jobs)

    while jobs or pq:
        while jobs and st < jobs[0][0] <= now:
            w_time, w_access = jobs.popleft()
            heapq.heappush(pq, [w_access, w_time])

        if pq:
            cur = heapq.heappop(pq)
            st = now
            now += cur[0]
            ans += (now - cur[1])
        else:
            now += 1

    return ans // tot