import sys

input = sys.stdin.readline
T = int(input())
for t in range(T) :
    n = int(input())
    lst = list(map(int,input().split()))

    cnt = 0
    value=0
    M=0
    for i in range(n-1,-1,-1):
        if(lst[i] > M):
            M = lst[i]
        else:
            value+=M-lst[i]
    print(value)

