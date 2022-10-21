import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
sensor = sorted(list(map(int, input().split())))

diff = []
for i in range(n-1):
    diff.append(sensor[i+1] - sensor[i])

diff.sort()
answer = 0

for i in range(n-k):
    answer += diff[i]

print(answer)