import sys
input = sys.stdin.readline
n,m = map(int, input().split())
ans = sorted(list(set([input().rstrip() for i in range(n)]) & set([input().rstrip() for i in range(m)])))
print(len(ans), *ans, sep='\n')