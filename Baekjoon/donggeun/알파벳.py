import sys
input = sys.stdin.readline
dx = [1,0,-1,0]
dy = [0,1,0,-1]
r,c = map(int,input().split())
graph = [list(map(str,input().rstrip())) for _ in range(r)]
ans = {1}
tmp = [False]*(26)
def dfs(a,b,d,dic):
    for i in range(4):
        nx = a+dx[i]
        ny = b+dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
            continue
        alpha= ord(graph[nx][ny])-65
        if not dic[alpha]:
            ans.add(d+1)
            dic[alpha] = True
            dfs(nx,ny,d+1,dic)
            dic[alpha] = False
            
tmp[ord(graph[0][0])-65]= True
dfs(0,0,1,tmp)
print(max(ans))