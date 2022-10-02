from collections import deque

def bfs():
    q = deque()
    q.append(n)
    while q:
        v = q.popleft()
        if v == k:
            print(visited[v])
            ans = []
            while v != n:
                ans.append(v)
                v = grid[v]
            ans.append(n)
            ans.reverse()  
            print(' '.join(map(str, ans)))
            return
        for next in (v-1, v+1, v*2):
            if 0 <= next < M and not visited[next]:
                visited[next] = visited[v] + 1
                q.append(next)
                grid[next] = v  

n, k = map(int, input().split())
M = int(10e5)
visited = [0] * M
grid = [0] * M
bfs()