from collections import deque

def solution(priorities, location):
    n = len(priorities)
    que = deque([])
    for i in range(n):
        que.append((i, priorities[i]))
    high_prior = max(que, key=lambda x:x[1])[1]
    count = 1
    while que:
        high_prior = max(que, key=lambda x:x[1])[1]
        idx, now = que.popleft()
        if now == high_prior:
            if idx == location:
                return count
            count += 1
        else:
            que.append((idx, now))