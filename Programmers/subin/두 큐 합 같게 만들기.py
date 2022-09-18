from collections import deque
def solution(queue1, queue2):

    q1 = deque(queue1)
    q2 = deque(queue2)

    length = len(queue1) + len(queue2)

    count = 0

    sum_q1 = sum(q1)
    sum_q2 = sum(q2)

    while True:

        if sum_q1 > sum_q2:
            value = q1.popleft()
            sum_q1 -= value
            q2.append(value)
            sum_q2 += value

        elif sum_q2 > sum_q1:
            value = q2.popleft()
            sum_q2 -= value
            q1.append(value)
            sum_q1 += value
        else:
            break

        if count > length and sum_q1 != sum_q2:
            break

        count += 1

    if sum_q1 != sum_q2:
        return -1
    else:
        return count

