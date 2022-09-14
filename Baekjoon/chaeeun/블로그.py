# (시간초과)

import sys

### input
day, period = [int(x) for x in sys.stdin.readline().split()]
visits = [int(x) for x in sys.stdin.readline().split()]

### output
if max(visits) == 0:
  print('SAD')
else:
  sums = [] ## 최대 방문자수 구하기 위한 기간 내 방문자수 합 모아놓은 배열 만들기
  for i in range(len(visits)):
    sum = 0
    for j in range(period):
      if i+j < len(visits):
        sum += visits[i+j]
        sums.append(sum)
  print(max(sums)) ## 최대 방문자수
  print(sums.count(max(sums))) ## 최대 방문자수의 기간 개수 구하기