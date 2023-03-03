import sys
input = sys.stdin.readline

word = list(input().rstrip())
lis = []
stk = []
m = int(input())
for i in range(m):
    code = input().rstrip()
    lis.append(code)

for j in lis:
    if j == "L":
        if len(word) != 0:
            stk.append(word.pop())
    elif j == "D":
        if len(stk) != 0:
            word.append(stk.pop())
    elif j == "B":
        if len(word) != 0:
            word.pop()
    else:
        a, b = j.split()
        word.append(b)
print("".join(word + stk[::-1]))