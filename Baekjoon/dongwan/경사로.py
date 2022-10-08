import sys

def pos(now):

    for j in range(1, n):
        if abs(now[j] - now[j - 1]) > 1:
            return False
        if now[j] < now[j - 1]:           
            for k in range(l): 
                if j + k >= n or visited[j + k] or now[j] != now[j + k]: 
                    return False
                if now[j] == now[j + k]:  
                    visited[j + k] = 1
        elif now[j] > now[j - 1]:       
            for k in range(l):
                if j - k - 1 < 0 or now[j - 1] != now[j - k - 1] or visited[j - k - 1]:  
                    return False
                if now[j - 1] == now[j - k - 1]:   
                     visited[j - k - 1] = 1
    return True  

n, l = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
result = 0

for r in range(n):
    visited = [0 for _ in range(n)]  
    if pos(graph[r]):  
        result += 1

for c in range(n):
    visited = [0 for _ in range(n)]
    if pos([graph[r][c] for r in range(n)]):
        result += 1

print(result)