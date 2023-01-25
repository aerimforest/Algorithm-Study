"""
숫자 업데이트 하는데 반영이 안되는지 아직 해결못함..
"""
import sys
input = sys.stdin.readline

def delete_zero(lis: list) -> set:
    return set(lis) - {0}

def to_start(num: int) -> int:
    return (num // 3) * 3

def vertical(x: int, y: int) -> set:
    global board
    res = []
    for i in range(9):
        res.append(board[i][y])

    return delete_zero(res)

def horizontal(x: int, y: int) -> set:
    global board
    res = []
    for i in range(9):
        res.append(board[x][i])

    return delete_zero(res)

def square(x: int, y: int) -> set:
    global board
    res = []
    for i in range(to_start(x), to_start(x)+3):
        for j in range(to_start(y), to_start(y)+3):
            res.append(board[i][j])
    
    return delete_zero(res)

def candidate(x: int, y: int) -> list:
    return sorted(list(nums - (vertical(x,y) | horizontal(x,y) | square(x,y))))

def print_ans(lis):
    for i in range(len(zero)):
        x,y = zero[i][0], zero[i][1]
        board[x][y] = lis[i]

    for i in board:
        print(*i, sep='')

    sys.exit(0)
def bt(s):
    if len(s) == len(zero):
        print_ans(s)
        return

    for i in range(len(zero)):
        x,y = zero[i][0], zero[i][1]
        for num in candidate(x,y):
            if not visited[i]:
                global board
                visited[i] = True
                board[x][y] = num
                s.append(num)
                bt(s)
                board[x][y] = 0
                visited[i] = False

nums = set([i for i in range(1, 10)])
board = [list(map(int,input().rstrip())) for _ in range(9)]
zero = []

for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            zero.append((i,j))
visited = [False]*len(zero)

bt([])