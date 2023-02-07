from collections import deque
import sys
input = sys.stdin.readline

n,k = map(int,input().split())
min_point = 0
max_point = min(max(n,k)*2+1, 10**5)

visited = [-1]*(max_point+1)
pre_rounte = [-1]*(max_point+1)

def bfs(n):
    queue = deque()
    queue.append(n)
    visited[n] = 0

    while queue:
        now = queue.popleft()

        if now == k:
            return visited[now]

        for i in [now*2, now-1, now+1]:
            if not (min_point <= i <= max_point):
                continue

            if visited[i] == -1: # 방문한적 없다면
                queue.append(i)
                pre_rounte[i] = now
                visited[i] = visited[now] + 1

print(bfs(n))

pre = k
route_ans = [k]

while True:
    if pre == n:
        break
    route_ans.append(pre_rounte[pre])
    pre = pre_rounte[pre]

print(*reversed(route_ans))