import sys
input = lambda : sys.stdin.readline().strip()

s = input()
bomb = input()
stk = []
n = len(bomb)
last = bomb[-1]

for ss in s:
    stk.append(ss)
    if ss == last and ''.join(stk[-n:]) == bomb:
        for _ in range(n):
            stk.pop()

if stk:
    print(''.join(stk))
else:
    print("FRULA")
