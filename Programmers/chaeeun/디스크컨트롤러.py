# (참고)
# 최소 힙

import heapq

def solution(jobs):
    answer, now, i = 0, 0, 0
    start = -1
    heap = []

    while i < len(jobs):
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, [j[1], j[0]])
                
        if len(heap) > 0:
            current = heapq.heappop(heap)
            start = now
            now += current[0]
            answer += (now - current[1])
            i += 1
            
        else: # 남아있는 작업들의 요청시간이 아직 오지 않음
            now += 1

    # print(int(answer / len(jobs)))
    return int(answer / len(jobs))

# solution([[0, 3], [1, 9], [2, 6]])