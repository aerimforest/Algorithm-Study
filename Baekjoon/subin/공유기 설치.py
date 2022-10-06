n, c = map(int, input().split())
array = sorted([int(input()) for _ in range(n)])

start = 1
end = array[-1] - array[0]

result = 0
while(start <= end):
    value = array[0]
    mid = (start + end) // 2
    count = 1

    for i in range(1,n):
        if array[i] >= value + mid:
            count += 1
            value = array[i]
    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)