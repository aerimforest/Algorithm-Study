import sys
n, m = map(int, sys.stdin.readline().split())
ns = map(int, sys.stdin.readline().split())
def addtoM(ns, m):
    pairs = set([])
    dp = []
    if ns[0] % m == 0:
        pairs.add((0, 0))
    dp.append(ns[0])
    for i in range(1, len(ns)):
        # print(dp)
        if ns[i]%m == 0:
            pairs.add((i, i))
        for j in range(len(dp)):
            # print((ns[i] + dp[j]) % m)
            if (ns[i] + dp[j]) % m == 0:
                pairs.add((j, i))
            dp[j] += ns[i]
        dp.append(ns[i])
        # print(dp)
        # print(pairs)
    return len(pairs)
print(addtoM(ns, m))
