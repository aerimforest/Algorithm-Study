import sys
input = sys.stdin.readline
for _ in range(int(input())):
    print(0 if int(input()) % 10 != 0 else 1)