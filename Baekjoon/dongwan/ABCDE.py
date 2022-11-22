import sys 
input = sys.stdin.readline

n,m = map(int,input().split())

grid = [[] for i in range(n)]
visited = [0]*n

for i in range(m) :
    a,b = map(int,input().split())
    grid[a].append(b) 
    grid[b].append(a) 

def solution(x,depth) :
    if depth == 4 :
        print(1)
        sys.exit()

    for k in grid[x] :
        if not visited[k] : 
            visited[k] = 1 
            solution(k,depth+1)
            visited[k] = 0


for turn in range(n) :
    visited[turn] = 1 
    solution(turn,0)
    visited[turn] = 0
else :
    print(0)
