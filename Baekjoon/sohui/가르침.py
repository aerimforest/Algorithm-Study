import sys
from itertools import combinations

input = sys.stdin.readline
N, K = map(int, input().split())
arr = []

for _ in range(N):
    arr.append(input().rstrip())

new_visited = set([])
sw = True

if K < 5:
    sw = False
else:
    K = K - 5

for i in range(N):
    arr[i] = arr[i][4:-4]
    for x in arr[i]:
        if x != 'a' and x != 'n' and x != 't' and x != 'i' and x != 'c':
            new_visited.add(x)

new_visited = list(new_visited)
res = 0

if sw:
    if K > len(new_visited):
        K = len(new_visited)
    for comb in combinations(new_visited, K):
        cnt = 0
        for x in arr:
            for y in x:
                if y not in comb and y != 'a' and y != 'n' and y != 't' and y != 'i' and y != 'c':
                    break
            else:
                cnt += 1
        res = max(res, cnt)
    print(res)
else:
    print(0)