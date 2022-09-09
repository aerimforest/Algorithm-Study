# (참고)

from sys import stdin
import math

### 변수 선언
N = int(input())
nums = list(map(int, stdin.readline().strip().split()))
answer = 1
dic = {}

### 소수 찾기 함수
def primeNumber(n):
  ans = True
  for i in range(2, int(math.sqrt(n))+1):
    if n%i == 0:
      ans = False
      break
  return ans
  
### 최소공배수 구하기
for i in range(N):
  if primeNumber(nums[i]) and nums[i] not in dic:
    dic[nums[i]] = 1
    answer *= nums[i]

if answer == 1:
  answer = -1
else:
  int(answer)

print(answer)