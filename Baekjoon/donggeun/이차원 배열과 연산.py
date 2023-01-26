from collections import Counter
import sys
input = sys.stdin.readline

def is_row_high(arr: list[list]) -> bool:
    return len(arr) >= len(arr[0])

def correct(arr: list[list], r: int, c: int, k: int) -> bool:
    if len(arr) >= r and len(arr[0]) >= c:
        return arr[r-1][c-1] == k
    return False

def zero_padding(arr: list[list]):
    n = len(arr)
    max_idx = max([len(arr[i]) for i in range(n)])
    for i in range(n):
        arr[i].extend([0]*(max_idx - len(arr[i])))
    return arr

def reversing(arr: list[list]) -> list[list]:
    n = len(arr)
    m = len(arr[0])
    res = [[0]*n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            res[j][i] = arr[i][j]
    return res

def r_cal(arr: list[list]) -> list[list]:
    for i in range(len(arr)):
        tmp = sorted([(num, cnt) for num, cnt in Counter(arr[i]).items()], key=lambda x:(x[1], x[0]))
        sorted_tmp = []
        for num, cnt in tmp:
            if num != 0:
                sorted_tmp.append(num)
                sorted_tmp.append(cnt)
        arr[i] = sorted_tmp

    return zero_padding(arr)


def c_cal(arr: list[list]) -> list[list]:
    n = len(arr)
    m = len(arr[0])
    res = []
    for i in range(m):
        tmp = Counter([arr[j][i] for j in range(n)])
        tmp = sorted([(num,cnt) for num, cnt in tmp.items()], key=lambda x:(x[1],x[0]))
        sorted_tmp = []
        for num, cnt in tmp:
            if num != 0:
                sorted_tmp.append(num)
                sorted_tmp.append(cnt)
        res.append(sorted_tmp)

    res = zero_padding(res)
    return reversing(res)

def cutting(arr: list[list]) -> list[list]:
    n = len(arr)
    m = len(arr[0])

    if n > 100:
        arr = arr[:100]

    if m > 100:
        arr = [arr[i][:100] for i in range(len(arr))]

    return arr


r,c,k = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(3)]
sec = 0

while sec <= 100:
    if correct(arr, r,c,k):
        break
    if is_row_high(arr):
        arr = cutting(r_cal(arr))
    else:
        arr = cutting(c_cal(arr))
    sec += 1

print(sec if sec != 101 else -1)