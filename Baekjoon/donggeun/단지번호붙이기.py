import sys
input = sys.stdin.readline

n = int(input().rstrip())
graph = [list(map(int,input().rstrip())) for _ in range(n)]

def dfs(x,y):
    global cnt
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    if graph[x][y] == 1:
        cnt += 1
        graph[x][y] = 0
        dfs(x, y+1)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x-1, y)
        return True
    return False

cnt = 0
result = 0
ans = []
for i in range(n):
    for j in range(n):
        if dfs(i,j) == True:
            result += 1
            ans.append(cnt)
            cnt= 0
print(result, *sorted(ans), sep='\n')