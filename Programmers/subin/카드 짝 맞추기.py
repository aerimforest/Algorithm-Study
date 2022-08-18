from collections import deque
from collections import defaultdict
from copy import deepcopy
import sys

def solution(board, r, c):

    pair = defaultdict(list)

    for y in range(4):
        for x in range(4):
            if board[y][x] != 0:
                pair[board[y][x]].append((y,x))

    return p(list(pair.keys()), (r,c), board, pair)

def find(board, s, e):
    a, b, c, d = *s, *e
    que = deque([(a, b, 0)])
    cand = ((1, 0), (0,-1), (-1,0), (0, 1)) # 방향키
    confirm = {(a,b)}

    while que:
        y, x, cnt = que.popleft()

        if y == c and x == d:
            board[y][x] = 0
            return cnt

        for dy, dx  in cand:
            y1, x1 = y, x
            if 0 <= y + dy < 4 and 0 <= x + dx < 4 and (y + dy, x+ dx) not in confirm:
                que.append((y+dy, x+dx, cnt+1))
                confirm.add((y+dy, x+dx))

            while 0 <= y1 + dy < 4 and 0 <= x1 + dx < 4:
                y1 += dy
                x1 += dx
                if board[y1][x1] != 0:
                    break

            if (y1, x1) not in confirm:
                que.append((y1, x1, cnt+1))
                confirm.add((y1, x1))

def p(arr, s, board, pair) :
    if not arr:
        return 0

    answer = sys.maxsize

    for idx, num in enumerate(arr):

        a = find(board, s, pair[num][0]) + find(board, pair[num][0], pair[num][1]) + p(arr[:idx] + arr[idx +1:], pair[num][1], board, pair)
        board[pair[num][0][0]][pair[num][0][1]] = num
        board[pair[num][1][0]][pair[num][1][1]] = num

        b = find(board, s, pair[num][1]) + find(board, pair[num][1], pair[num][0]) + p(arr[:idx] + arr[idx+1:], pair[num][0], board, pair)
        board[pair[num][0][0]][pair[num][0][1]] = num
        board[pair[num][1][0]][pair[num][1][1]] = num

        answer = min(min(a,b) +2, answer)

    return answer