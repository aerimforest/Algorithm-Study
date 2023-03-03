import sys
from collections import deque
input = sys.stdin.readline

n,d,k,c = map(int,input().split())
sushi = [int(input()) for _ in range(n)]
sushi.extend(sushi[:k-1])

ans = 0
one, two = 0, k

while two < n+k and ans != k+1:
    ans = max(ans, len(set(sushi[one:two] + [c])))
    one += 1
    two += 1
print(ans)