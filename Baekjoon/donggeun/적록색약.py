import sys
sys.setrecursionlimit(10**4)
input = sys.stdin.readline

n=int(input())
graph = [list(map(str,input().rstrip())) for _ in range(n)]
nomal,color = 0,0
def dfs(x,y,color):
    if x <0 or x>=n or y<0 or y>=n:
        return False
    if graph[x][y] == color:
        if color == 'B':
            graph[x][y] = 'b' # 방문처리
        elif color == 'G' or color == 'R':
            graph[x][y] = 'c' # R과 G 동일하게 만듬
        else:
            graph[x][y] = 'v' # 적록색약의 방문처리
        dfs(x+1, y,color)
        dfs(x,y+1,color)
        dfs(x-1,y,color)
        dfs(x,y-1,color)
        return True
    return False

for i in range(n):
    for j in range(n):
        if dfs(i,j,'R'):
            nomal += 1
        elif dfs(i,j,'B'):
            nomal += 1
        elif dfs(i,j,'G'):
            nomal += 1
        
for i in range(n):
    for j in range(n):
        if dfs(i,j,'c'):
            color += 1
        elif dfs(i,j,'b'):
            color += 1

print(nomal, color)