n = int(input())
nums = sorted(list(map(int, input().split())))

i, j = 0, len(nums)-1
start, end = nums[i], nums[j]
result = abs(start+end)+1
r1, r2 = 0, 0

while i < j:
    mid = start+end

    if abs(mid) < result:
        result = abs(mid)
        r1, r2 = start, end

    if mid > 0:
        j -= 1
        end = nums[j]
    elif mid < 0:
        i += 1
        start = nums[i]
    else:
        break

print(r1, r2)