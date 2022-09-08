# (참고) 그래프. 백트래킹

def solution(info, edges):
    def nextNodes(v):
        temp = list()
        for e in edges:
            i, j = e # i는 부모노드, j는 자식노드
            if v == i: # 부모노드 번호 비교
                temp.append(j)
        return temp

    def dfs(sheep, wolf, current, path):
        ### 지금 노드 확인, 양 늑대 판별
        if info[current]:
            wolf += 1
        else:
            sheep += 1

        ### 늑대가 다 잡아먹음, 무시
        if sheep <= wolf:
            return 0

        ### 아니라면 임시 변수에 값 갱신
        maxSheep = sheep

        ### 서칭 시작
        for p in path:
            for n in nextNodes(p):
                if n not in path:
                    path.append(n)
                    ### 최대 양 판별
                    maxSheep = max(maxSheep, dfs(sheep, wolf, n, path))
                    path.pop()
        return maxSheep

    answer = dfs(0, 0, 0, [0])

    return answer
