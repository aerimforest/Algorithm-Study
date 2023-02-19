from collections import defaultdict
import sys
input = sys.stdin.readline

n,m = map(int, input().split())
main = defaultdict(list)

for _ in range(n):
    p,f,c = map(str,input().rstrip().split())

for _ in range(m):
    p,f,c = map(str,input().rstrip().split())

k = int(input())
for _ in range(k):
    a,b = map(str, input().rstrup().split())

q = int(input())
for _ in range(q):
    # / 로 스필릿하기
    path = list(map(str, input().rstrip().split("/")))

    for i in range(1, len(path)):
        main[path[i-1]].append(path[i])
