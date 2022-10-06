n, c = map(int, input().split())
lst = []
for _ in range(n):
    lst.append(int(input()))

lst.sort()

end = lst[-1] - lst[0]
start = 1
ans = 0

while start <= end:
    mid = (start + end)//2
    cnt = 1
    crr = lst[0]

    for i in range(1, n):
        if crr + mid <= lst[i]:
            cnt += 1
            crr = lst[i]

    if cnt < c: 
        end = mid - 1

    elif cnt >= c :
        start = mid + 1
        ans = mid

print(ans)