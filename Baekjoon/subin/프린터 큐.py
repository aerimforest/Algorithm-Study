t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    q = list(map(int, input().split()))

    idx = [False for _ in range(n)]
    idx[m] = True

    order = 0
    while True:
        if q[0] == max(q):
            order += 1
            if idx[0]:
                print(order)
                break
            else:
                q.pop(0)
                idx.pop(0)
        else:
            q.append(q.pop(0))
            idx.append(idx.pop(0))