from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

def bs(nums:list[int], target: int, origin_idx: int, del_idx: int) -> bool:
    n = len(nums)
    st,ed = 0, n-1

    while st <= ed:
        mid = (st + ed) // 2
        if nums[mid] == target:
            # target이랑 delete 한 숫자의 인덱스랑 다른 숫자가 있음
            if mid != origin_idx and mid != del_idx:
                return True
            # 찾은 값이 원본 값이랑 같음
            l = bisect_left(nums, nums[mid])
            r = bisect_right(nums, nums[mid])
            for i in range(l, r):
                if i != origin_idx and i != del_idx:
                    print(origin_idx, del_idx, l, r, i)
                    return True
            return False
            
        elif nums[mid] < target:
            st = mid + 1
        elif nums[mid] > target:
            ed = mid - 1
    return False

n = int(input())
nums = sorted(list(map(int,input().split())))
ans = 0

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if bs(nums, nums[i] - nums[j], i, j):
            # nums에서 nums[i] - nums[j]  값을 찾을 꺼야 
            # 근데 nums[i] - nums[j] 이 값이 nums[i]의 인덱스랑 nums[j]
            # print(i, nums[i]-nums[j], i-j)
            ans += 1
            break
print(ans)



