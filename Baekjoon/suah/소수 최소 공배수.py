import math
import sys
input = lambda : sys.stdin.readline().strip()

def is_prime(x):
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0 :
            return False
    return True


n = int(input())
arr = set(map(int, input().split()))   # 중복되는 숫자 방지
temp = []

answer = 1
for a in arr:
    if is_prime(a):
        answer *= a

if answer == 1:
    print(-1)
else:
    print(answer)
