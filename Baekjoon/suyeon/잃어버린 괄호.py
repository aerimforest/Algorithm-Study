import sys

input = lambda: sys.stdin.readline()

answer = 0
expression = input().split('-')

for i in expression[0].split('+'):
    answer += int(i)

for i in expression[1:]:
    for j in i.split('+'):
        answer -= int(j)

print(answer)
