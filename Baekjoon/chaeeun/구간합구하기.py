# (참고)

### input
import sys
input = sys.stdin.readline
from math import ceil, log

N, M, K = map(int,input().split())

l = []
segment_tree = [0]*(N*4)


### 트리 만들기
def init(start, end, index):
	# start와 end가 같다면 리프노드
    if start == end:
        segment_tree[index] = l[start-1]
        return segment_tree[index]
	
    ### 현재 노드는 왼쪽 아래 노드와 오른쪽 아래 노드를 더한 값
    mid = (start+end) // 2
    segment_tree[index] = init(start, mid, index*2) + init(mid+1, end, index*2+1)
    return segment_tree[index]

       
### 트리에서 값 찾기
def find(start, end, index, left, right):
	  ## 찾으려는 범위가 start~end 범위보다 클 경우
    if start > right or end < left:
        return 0
        
    ## 찾으려는 범위가 segment tree 노드안에 구현되어 있을 경우
    if start >= left and end <= right:
        return segment_tree[index]

    ## 현재 노드는 왼쪽아래 + 오른쪽아래 노드
    mid = (start + end) // 2
    sub_sum = find(start, mid, index*2, left, right) + find(mid+1, end, index*2+1, left, right)
    return sub_sum


### 트리 값 바꿔주기
def update(start, end, index, update_idx, update_data):
	  ## update 하려는 범위가 초과될 경우
    if start > update_idx or end < update_idx:
        return
    
    segment_tree[index] += update_data
	
    ## 리프노드까지 바꿔주었으면 재귀함수를 끝냄
    if start == end:
        return

	  ## 내가 관여하고 있는 노드들을 찾아서 바꿔주기 (재귀함수)
    mid = (start + end) // 2
    update(start, mid, index*2, update_idx, update_data)
    update(mid+1, end, index*2+1, update_idx, update_data)


for _ in range(N):
    l.append(int(input()))

init(1, N, 1)

for _ in range(M+K):
    a, b, c = map(int,input().split())
    if a == 1:
        temp = c - l[b-1]
        l[b-1] = c
        update(1, N, 1, b, temp)

    elif a == 2:
        print(find(1, N, 1, b, c))