"""경우의 수가 왼쪽으로 쭉 가기, 오른쪽으로 쭉 가기 만 있을 줄 알았는데 그게 아니였다는..
왼쪽으로 갔다가 오른쪽으로 다시 가는 경우와 왼쪽으로 갔다가 오른쪽으로 가는 경우도 고려해야 함.
ex) BCAAAAAAAAAAAZ 이런 경우는 한방향으로 가기보단 C까지 갔다가 다시 돌아오는게 효율적
"""

def solution(name):
    fore_ans = 0
    back_ans = 0
    n = len(name)
    reversed_name = name[0] + name[::-1][:n-1]

    for i in range(n):
        if "A" != name[i]:
            fore_ans += min(ord(name[i])-ord("A"), ord("Z")-ord(name[i])+1)
        if i != (n-1) and name[i+1:].count("A") != len(name[i+1:]):
            fore_ans += 1

        if "A" != reversed_name[i]:
            back_ans += min(ord(reversed_name[i])-ord("A"), ord("Z")-ord(reversed_name[i])+1)
        if i != (n-1) and reversed_name[i+1:].count("A") != len(reversed_name[i+1:]):
            back_ans += 1

    return min(fore_ans, back_ans)