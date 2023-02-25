import sys

input = sys.stdin.readline

dx = [1,-1,0,0,1,-1,1,-1]
dy = [0,0,1,-1,-1,-1,1,1]

# 입력받을 값들 
move = ["R", "L", "B", "T", "RT", "LT", "RB", "LB"]
alpha = ["A", "B", "C", "D", "E", "F", "G", "H"]

king, stone, n = map(str, input().rstrip().split())

k_pos = [alpha.index(king[0]), 8 - int(king[1])]
s_pos = [alpha.index(stone[0]), 8 - int(stone[1])]

for i in range(int(n)):
    idx = move.index(input().rstrip())

    nx = k_pos[0] + dx[idx]
    ny = k_pos[1] + dy[idx]

    if nx < 0 or ny < 0 or nx > 7 or ny > 7:
        continue

    if nx == s_pos[0] and ny == s_pos[1]:
        px = s_pos[0] + dx[idx]
        py = s_pos[1] + dy[idx]

        if px < 0 or py < 0 or px > 7 or py > 7:
            continue

        s_pos[0] = px
        s_pos[1] = py

    k_pos[0] = nx
    k_pos[1] = ny

k_result = alpha[k_pos[0]] + str(8-k_pos[1])
s_result = alpha[s_pos[0]] + str(8-s_pos[1])

print(k_result)
print(s_result)