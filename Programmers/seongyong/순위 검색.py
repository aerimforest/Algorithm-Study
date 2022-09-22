# main logic
from bisect import bisect_left
from collections import defaultdict


def find_targets_dfs(requires: list, targets: list, table):
    if not table: return

    if not requires:
        targets.append(table)
        return

    require = requires.pop()
    if require == '-':
        for next_table in table.values():
            find_targets_dfs(requires, targets, next_table)
    elif require in table:
        find_targets_dfs(requires, targets, table[require])

    requires.append(require)


def solution(info, query):
    info_sep = ' '
    que_sep = ' and '

    table = defaultdict(lambda: defaultdict(lambda: defaultdict(dict)))
    info = list(map(lambda line: line.split(info_sep), info))
    for i in range(len(info)):
        lang, major, career, soul_food, score = info[i]
        if soul_food not in table[lang][major][career]:
            table[lang][major][career][soul_food] = list()
        table[lang][major][career][soul_food].append(int(score))

    for lang in ['cpp', 'java', 'python']:
        for major in ['backend', 'frontend']:
            for career in ['junior', 'senior']:
                for soul_food in ['chicken', 'pizza']:
                    if soul_food in table[lang][major][career]:
                        table[lang][major][career][soul_food].sort()

    answer = list()
    for q in query:
        lang, major, career, soul_food, min_score = q.replace(que_sep, info_sep).split(info_sep)
        targets = list()
        find_targets_dfs([soul_food, career, major, lang], targets, table)

        count = 0
        for target in targets:
            count += len(target) - bisect_left(target, int(min_score))

        answer.append(count)

    return answer


# 비슷한데 더 간단한 코드
# def solution(info, query):
#     data = dict()
#     for a in ['cpp', 'java', 'python', '-']:
#         for b in ['backend', 'frontend', '-']:
#             for c in ['junior', 'senior', '-']:
#                 for d in ['chicken', 'pizza', '-']:
#                     data.setdefault((a, b, c, d), list())
#     for i in info:
#         i = i.split()
#         for a in [i[0], '-']:
#             for b in [i[1], '-']:
#                 for c in [i[2], '-']:
#                     for d in [i[3], '-']:
#                         data[(a, b, c, d)].append(int(i[4]))

#     for k in data:
#         data[k].sort()

#         # print(k, data[k])

#     answer = list()
#     for q in query:
#         q = q.split()

#         pool = data[(q[0], q[2], q[4], q[6])]
#         find = int(q[7])
#         l = 0
#         r = len(pool)
#         mid = 0
#         while l < r:
#             mid = (r+l)//2
#             if pool[mid] >= find:
#                 r = mid
#             else:
#                 l = mid+1
#             # print(l, r, mid, answer)
#         # answer.append((pool, find, mid))
#         answer.append(len(pool)-l)

#     return answer
