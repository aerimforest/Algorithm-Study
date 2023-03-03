"""
풀이
dp 를 사용해서 모든 위치에서 팰린드롬 가능한지에 대해 판별
ex) n,nums = 10, [1,1,5,6,7,7,6,5,5,5]

1 1 0 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 1 0 0
0 0 0 1 0 0 1 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1 1 1
0 0 0 0 0 0 0 0 1 1
0 0 0 0 0 0 0 0 0 1

dp[i][j]와 dp[i][j+k] 가 모두 1이라면 nums[i] 에서 nums[j+k]는 팰린드롬

길이가 짝수인 팰린드롬의 인덱스를 구해서 큐에 삽입

queue = [[0,1], [2,7], [3,6], [4,5], [7,8], [8,9]]

X X 0 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0
0 0 X 0 0 0 0 X 0 0
0 0 0 X 0 0 X 0 0 0
0 0 0 0 X X 0 0 0 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 X X 1
0 0 0 0 0 0 0 0 X X
0 0 0 0 0 0 0 0 0 1

작업 스케줄링 알고리즘(그리디) 사용하여 가장 빠른 인덱스 선택
만약 시작인덱스가 1이 아니거나 중간에 빈 곳이 있거나 끝나는 부분이 n이 아니라면 -1

dp 테이블 만들기 전에 각 요소 갯수 중 홀수인게 있다면 -1 
"""


from collections import Counter, defaultdict, deque
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))

pair = defaultdict(bool)
cnt_num = Counter(nums)

dp = [[0]*(n) for _ in range(n)]

for cnt in cnt_num.values():
    if cnt%2:
        print(-1)
        exit()

for i in range(n):
    for start in range(n-i):
        end = start + i
        if start==end:
            dp[start][end]=1
        elif nums[start] == nums[end]:
            if start+1==end:
                dp[start][end]=1
            elif dp[start+1][end-1] == 1:
                dp[start][end] = 1



for i in range(n):
    for j in range(n):
        print(dp[i][j], end=' ')
    print()

queue = deque()
for i in range(n):
    for j in range(i+1,n,2):
        if dp[i][j]:
            queue.append([i,j])

ans = 0
ed_idx = -1

order_arr = []
while queue:
    st, ed = queue.popleft()
    if st > ed_idx:
        order_arr.append([st, ed])
        ans += 1
        ed_idx = ed
        
collect_st = 0
for st, ed in order_arr:
    if st == collect_st:
        collect_st = ed + 1
    else:
        print(-1)
        break
else:
    print(ans if collect_st == n else -1)