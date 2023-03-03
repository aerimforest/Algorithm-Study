# [17298] 오큰수

import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
A = list(map(int, input().split()))

# 현재 위치에서 오른쪽에 있는 수 중 더 큰 수 중 가장 왼쪽에 있는 수
## 없으면 -1

answer = [-1]*N
stack = deque()

# 이중 for 문으로 하면 안됨... stack 사용해야 함

# A 원소 하나씩 돌아가면서 확인
## 스택 비어있으면 우선 push
## 그 다음 원소가 작으면 스택에 push
## 그 다음 원소가 스택의 가장 맨 위 값보다 크다면 pop을 하고 answer 배열에 현재 원소값 넣어줌
## (( 현재 원소가 스택의 값보다 크지 않을 때까지 반복 )) 
## 다 옮겼으면 현재 원소를 스택에 push

for i in range(N):
    while stack and (stack[-1][0] < A[i]):
        val, idx = stack.pop()
        answer[idx] = A[i] # 현재 값 넣어줌
    
    stack.append([A[i], i]) ## 인덱스와 함께 넣어줌!

print(*answer)