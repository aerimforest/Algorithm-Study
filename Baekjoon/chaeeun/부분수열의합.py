N, S = map(int, input().split())
nums = list(map(int, input().split()))

answer = 0
def dfs(idx, sum):
    global answer

    if idx >= N: # 수열의 마지막 인덱스까지 접근
        return
        
    sum += nums[idx]

    if S == sum: # 입력 받은 S 값과 sum이 같아질 경우
        answer += 1

    dfs(idx+1, sum-nums[idx]) # 현재 idx에 해당하는 원소 뺀 sum
    dfs(idx+1, sum) # 현재 idx에 해당하는 원소 포함한 sum

dfs(0,0)
print(answer)