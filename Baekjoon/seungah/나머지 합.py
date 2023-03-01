# 나머지 합 (누적 합)
import sys
input = sys.stdin.readline

# N: 숫자 개수, M: 나누는 수
N, M = map(int, input().split())
A = list(map(int, input().split()))
pre_sum = [0]*M # 누적 합을 M으로 나눈 나머지가 index
answer = 0
# N에서 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수 구하기
total = 0 # 누적 합
for i in range(N):
    total += A[i]
    idx = total % M
    pre_sum[idx] += 1 # count

answer  += pre_sum[0]

# 부분합은 pre_sum[i] - pre_sum[j] 로 구하고, 해당 값이 0이면 M으로 나누어 떨어짐
## 각 나머지 인덱스에서 2개의 수를 뽑으면 나머지 0인 구간을 구할 수 있음

for i in pre_sum:
    answer += i * (i-1) // 2 # nC2

print(answer)

