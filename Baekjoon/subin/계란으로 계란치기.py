import sys

N = int(sys.stdin.readline())
S = []
W = []
for _ in range(N):
    s, w = map(int, sys.stdin.readline().split())
    S.append(s)
    W.append(w)

ans = 0
broken = [False] * N


def rec(i):
    global ans
    if i >= N:
        ans = max(ans, sum(broken))
        return

    flag = False
    for j in range(N):
        if j != i and not broken[i] and not broken[j]:
            S[i] -= W[j]
            S[j] -= W[i]
            if S[i] <= 0:
                broken[i] = True
            if S[j] <= 0:
                broken[j] = True
            flag = True
            rec(i + 1)
            if S[i] <= 0:
                broken[i] = False
            if S[j] <= 0:
                broken[j] = False
            S[i] += W[j]
            S[j] += W[i]

    if not flag:
        rec(i + 1)


rec(0)
print(ans)