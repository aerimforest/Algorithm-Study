n, m = map(int, input().split())
array = list(map(int, input().split()))
start = max(array)
end = sum(array)

while start <= end:
    mid = (start + end) // 2
    count = 0  # 블루레이 개수
    data = 0  # 레슨 합
    for i in range(n):
        if data + array[i] > mid:
            count += 1
            data = 0
        data += array[i]

    if data != 0:
        count += 1
    if count <= m:
        end = mid - 1
    else:
        start = mid + 1

print(start)