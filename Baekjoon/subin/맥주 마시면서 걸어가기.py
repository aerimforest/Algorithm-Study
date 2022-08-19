from collections import deque

Test = int(input())

for _ in range(Test):
    conv_store = set()
    n_store = int(input())
    start = list(map(int, input().split()))

    for _ in range(n_store):
        x, y = map(int, input().split())
        conv_store.add((x, y))

    end = list(map(int, input().split()))

    queue = deque([end])
    answer = False
    while queue:
        x, y = queue.popleft()

        if abs(x - start[0]) + abs(y - start[1]) <= 1000:
            print("happy")
            answer = True
            break

        remove_list = []
        for nx, ny in conv_store:
            if abs(x - nx) + abs(y - ny) <= 1000:
                queue.append([nx, ny])
                remove_list.append((nx, ny))

        for tar in remove_list:
            conv_store.remove(tar)

    if not answer:
        print("sad")