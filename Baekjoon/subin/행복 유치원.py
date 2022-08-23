n, k = map(int, input().split())
height = list(map(int, input().split()))

diff = []
for i in range(n-1):
    diff.append(height[i+1] - height[i])

diff.sort()
cost = 0
for i in range(n-k):
    cost += diff[i]

print(cost)