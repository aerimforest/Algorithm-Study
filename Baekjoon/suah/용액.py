import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
min_n = sys.maxsize
ans_s, ans_e = 0, len(arr)-1

s, e = 0, len(arr)-1

while s < e:
    summ = arr[s] + arr[e]

    if abs(summ) < min_n:
        min_n = abs(summ)
        ans_s = s
        ans_e = e

    if summ > 0:
        e -= 1
    elif summ < 0:
        s += 1
    else:
        break

print(arr[ans_s], arr[ans_e])
