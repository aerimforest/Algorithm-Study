k, n = map(int, input().split())
lan = [int(input()) for _ in range(k)]

start = 1
end = max(lan)

while start <= end:
    mid = (start + end) // 2

    temp = 0
    for i in lan:
        temp += i // mid

    if temp < n:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)