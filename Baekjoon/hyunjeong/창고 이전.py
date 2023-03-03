import sys
from collections import deque


n, m, k = map(int, sys.stdin.readline().split())
n_container = deque([])
m_container = deque([])

n_temp = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
m_temp = [list(map(int,sys.stdin.readline().split())) for _ in range(m)]

x, y = 0, 0
for i in range(n):
    n_container.append((n_temp[i], i+1))

for i in range(m):
    m_container.append((m_temp[i], i+1))


# ##############FOR TESTING##################
# n, m, k = 1, 1, 1
# n_container = deque([])
# m_container = deque([])
# n_container.append((1, 1))
# m_container.append((1, 1))
# x, y = 0, 0

n_left = []
m_left = []
def calculate(n_count, n_floor, m_count, m_floor, x, y):
    if n_count == 0 or m_count == 0:
        if n_count == 0 and m_count != 0:
            m_left.insert(0, (m_count, m_floor))
        if n_count != 0 and m_count == 0:
            n_left.insert(0, (n_count, n_floor))                    
    elif n_count > m_count:
        x += m_count
        y += n_floor + m_floor
        n_left.insert(0, (n_count-m_count, n_floor))
    elif n_count < m_count:
        x += n_count
        y += n_floor + m_floor
        m_left.insert(0, (m_count-n_count, m_floor))
    else:
        x += m_count
        y += n_floor + m_floor
    return x, y

while n_container or m_container:
    if (not n_left) and (not m_left):
        n_count, n_floor = n_container.popleft()
        m_count, m_floor = m_container.popleft()
        # print(n_count, n_floor, m_count, m_floor)
    elif not n_left and m_left:
        n_count, n_floor = n_left.pop(0)
        m_count, m_floor = m_container.popleft()
        # print(n_count, n_floor, m_count, m_floor)
    else:
        n_count, n_floor = n_container.popleft()
        m_count, m_floor = m_left.pop(0)
        # print(n_count, n_floor, m_count, m_floor)

    x, y = calculate(n_count, n_floor, m_count, m_floor, x, y)

print(x, y)



