import heapq
n = int(input())
nums = list(map(int,input().split()))

start = 0
end = n-1
res = []
while start < end:
    diff = nums[end]+nums[start]
    if diff>0:
        heapq.heappush(res, (diff, nums[start], nums[end]))
        end -= 1
    elif diff<0:
        heapq.heappush(res, (-diff, nums[start], nums[end]))
        start += 1
    else:
        heapq.heappush(res, (diff, nums[start], nums[end]))
        break
ans, a, b= heapq.heappop(res)
print(a,b)