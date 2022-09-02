import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
f, b = input().split("*")
for _ in range(n):
    file = input()
    if file[:len(f)] == f and file[-len(b):] == b and len(f+b) <= len(file):
        print("DA")
    else:
        print("NE")
