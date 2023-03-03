import sys
input = sys.stdin.readline

n = int(input())
board = [list(map(str, input().rstrip())) for _ in range(n)]

dx = [0,-1,0,1]
dy = [1,0,-1,0]

idx = 1
def serch(i,j, target):
    global idx
    # print("함수 시작", idx, "idx", i, j, target)
    idx +=1
    ni = i
    res1 = 0
    while ni < n:
        if board[ni][j] == target:
            ni += 1
            res1 += 1
        else:
            break
    ni = i
    res1 -= 1
    while 0 <= ni:
        if board[ni][j] == target:
            ni -= 1
            res1 += 1
        else:
            break
    
    nj = j
    res2 = 0
    while nj < n:
        if board[i][nj] == target:
            nj += 1
            res2 += 1
        else:
            break
    
    nj = j
    res2 -= 1
    while 0 <= nj:
        if board[i][nj] == target:
            nj -= 1
            res2 += 1
        else:
            break
    
    return max(res1, res2)

ans = 0
for i in range(n):
    for j in range(n):
        if i == n-1 and j == n-1:
            continue
        elif i == n-1:
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            ans = max(ans, serch(i,j, board[i][j]))
            ans = max(ans, serch(i,j+1, board[i][j+1]))
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]            
        elif j == n-1:
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            ans = max(ans, serch(i,j, board[i][j]))
            ans = max(ans, serch(i+1,j, board[i+1][j]))
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            
        else:
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            ans = max(ans, serch(i,j, board[i][j]))
            ans = max(ans, serch(i,j+1, board[i][j+1]))
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]


            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            ans = max(ans, serch(i,j, board[i][j]))
            ans = max(ans, serch(i+1,j, board[i+1][j]))
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            
print(ans)