import sys
input = sys.stdin.readline

q = list(input().rstrip())
w = list(input().rstrip())

final = []
for i in q:
    final.append(i)

    if final[-len(w):] == w:
        for j in w:
            final.pop()

print(''.join(final) if len(final) > 0 else 'FRULA')