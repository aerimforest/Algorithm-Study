from itertools import combinations
from collections import defaultdict


def solution(orders, course):
    answer = []
    orders = list(map(set, orders))
    for n in course:
        dict_n_combo = defaultdict(list[tuple])  # check if error
        visited = set()
        for i in orders:
            for combo in combinations(i, n): #combination이 자꾸 겹쳐서 나옴
                if combo not in visited:
                    visited.add(combo)
                    count = 0
                    for order in orders:
                        if set(combo).issubset(order): count += 1

                    if count >= 2: dict_n_combo[count].append(combo)

        if len(dict_n_combo) != 0:
            answer.extend(sorted(dict_n_combo.items())[-1][1])

    answer.sort()
    return answer
