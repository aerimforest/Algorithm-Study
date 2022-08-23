n, k = map(int, input().split())
Length = list(map(int, input().split()))
res = []

for i in range(0, n - 1):
    res.append(Length[i+1] - Length[i])

res.sort()
result = 0

for i in range(n - k):
    result += res[i]

print(result)