from itertools import combinations
from collections import defaultdict


def solution(orders, course):
    answer = []
    set_orders = list(map(set, orders))
    for n in course:
        dict_n_combo = defaultdict(list)  #dictionary : key = count of combo, value = combo
        visited = set()
        for order in orders: # count possible combo while iterating orders
            for combo in combinations(order, n):
                combo = tuple(sorted(combo))
                if combo not in visited:
                    visited.add(combo)
                    count = 0
                    for set_order in set_orders:
                        if set(combo).issubset(set_order): count += 1

                    if count >= 2: dict_n_combo[count].append(''.join(combo)) 

        if len(dict_n_combo) != 0: # append max order to answer
            dict_n_combo = sorted(dict_n_combo.items())
            max_ordered = dict_n_combo[-1][0]
            while dict_n_combo and dict_n_combo[-1][0] == max_ordered: # consider multiple max order
                answer.extend(dict_n_combo.pop()[1])

    answer.sort()
    return answer
