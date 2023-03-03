import sys
from collections import deque


# a = map(int, sys.stdin.readline().split())
# lst = [list(map(int,sys.stdin.readline().split())) for _ in range(a)]

a = 4
lst = [3, 5, 2, 7]
dp = [0] * a
dp[-1] = lst[-1]
ans = [-1] * a
for i in range(a-1):
    print(i)
    for j in range(i+1, a):
        print(i)
        if lst[j] > lst[i]:
            print(lst[j], lst[i])
            ans[i] = lst[j]
            break
print(ans) 

