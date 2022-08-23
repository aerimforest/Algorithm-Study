import sys

N, K = map(int, input().split())

children = list(map(int, sys.stdin.readline().split()))
print(sum(sorted([children[i] - children[i - 1] for i in range(1, N)])[:N - K]))
