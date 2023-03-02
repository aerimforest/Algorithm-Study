from collections import deque
import sys
input = sys.stdin.readline

f,s,g,u,d = map(int,input().split())

def bfs(st):
    queue = deque()
    queue.append([st, 0])
    visited = [False]*(f+1)
    visited[st] = True

    while queue:
        now, time = queue.popleft()
        if now == g:
            return time
        
        for nxt in [now+u, now-d]:
            if nxt < 1 or f < nxt:
                continue
            
            if not visited[nxt]:
                queue.append([nxt, time+1])
                visited[nxt] = True
    return "use the stairs"

print(bfs(s))