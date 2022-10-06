n = int(input())
budget = list(map(int, input().split()))
m = int(input())

left, right = 1, max(budget)
while left <= right:
    mid = (left + right) // 2
    total = 0

    for i in budget:
        total += min(i, mid)

    if total > m:
        right = mid - 1
    else:
        left = mid + 1

print(right)