import sys

input = lambda: sys.stdin.readline().rstrip()

origin, bomb = input(), list(input())

stack = []
len_bomb = len(bomb)

for o in origin:
    stack.append(o)

    if len(stack) >= len_bomb and stack[-len_bomb:] == bomb:
        for _ in bomb:
            stack.pop()

print(''.join(stack) if stack else "FRULA")
