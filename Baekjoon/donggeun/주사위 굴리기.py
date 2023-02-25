import sys
input = sys.stdin.readline

n, m, y, x, k = map(int, input().split())
MAP = []
for _ in range(n):
    MAP.append(list(map(int, input().split())))
nums = list(map(int, input().split()))

dice = [0]*6

# 1 : 왼 오 앞 뒤 아래 위
# 2 : 오 왼 앞 뒤 위 아래
# 3 : 뒤 앞 위 아래 왼 오
# 4 : 앞 뒤 아래 위 왼 오
flip_data = [[4, 5, 2, 3, 1, 0],
             [5, 4, 2, 3, 0, 1],
             [3, 2, 0, 1, 4, 5],
             [2, 3, 1, 0, 4, 5]]
dx = [1, -1 , 0, 0]
dy = [0, 0, -1, 1]
for i in nums:
    i-=1
    x+=dx[i]
    y+=dy[i]

    if not 0<=x<m or not 0<=y<n:
        x-=dx[i]
        y-=dy[i]
        continue
    
    temp = [0]*6
    for j in range(6):
        temp[j] = dice[flip_data[i][j]]
    dice = temp

    if MAP[y][x] == 0:
        MAP[y][x] = dice[1]
    else:
        dice[1] = MAP[y][x]
        MAP[y][x] = 0
    print (dice[0])