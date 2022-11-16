m, n, l = map(int, input().split())
shooters = list(map(int, input().split()))
animals = []
for _ in range(n):
    x, y = map(int, input().split())
    if y <= l:
        animals.append((x, y))
shooters.sort()
animals.sort(key=lambda axis: axis[0])
ans = 0
idx = 0
for i in range(len(animals)):
    left, right = idx, len(shooters)-1
    mid = 0
    while left <= right:
        mid = (left+right)//2
        if shooters[mid] <= animals[i][0]:
            if len(shooters) - 1 == mid or shooters[mid+1] > animals[i][0]:
                break
            left = mid + 1
        else:
            right = mid - 1
    idx = mid
    if abs(animals[i][0] - shooters[mid]) + animals[i][1] <= l:
        ans += 1
    elif len(shooters) > mid+1 and abs(animals[i][0] - shooters[mid+1]) + animals[i][1] <= l:
        ans += 1
print(ans)
