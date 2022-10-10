n = int(input())
data = list(map(int, input().split()))
data.sort()

weight = 1
for d in data:
    if weight >= d:
        weight += d
    else:
        break

print(weight)