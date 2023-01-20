import sys
input = sys.stdin.readline

n = int(input())
colors = [list(map(int,input().rstrip().split())) for _ in range(n)]

for i in range(1,n):
    colors[i][0] = min(colors[i-1][1], colors[i-1][2]) + colors[i][0]
    colors[i][1] = min(colors[i-1][0], colors[i-1][2]) + colors[i][1]
    colors[i][2] = min(colors[i-1][1], colors[i-1][0]) + colors[i][2]

print(min(colors[-1]))