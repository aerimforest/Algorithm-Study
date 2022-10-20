import sys

n, k = map(int, input().split())

count = 0;

while bin(n).count('1') > k:
    n = n+1
    count = count +1

print(count)
