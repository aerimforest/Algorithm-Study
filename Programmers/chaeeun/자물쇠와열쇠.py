# (참고)
# 핵심 : lock 배열을 확장

# 90도 회전시키기
def rotation(arr):
    n = len(arr)
    rect = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            rect[j][n-1-i] = arr[i][j]
    return rect

# 자물쇠가 열리는지 체크
def check(startX, startY, key, lock, expendSize, start, end):
    expendList = [[0] * expendSize for _ in range(expendSize)]

    # expendList에 key 추가
    for i in range(len(key)):
        for j in range(len(key)):
            expendList[startX + i][startY + j] += key[i][j]

    # expendList에 lock 추가하면서 기존 값이랑 더하기
    for i in range(start, end):
        for j in range(start, end):
            expendList[i][j] += lock[i - start][j - start]
            if expendList[i][j] != 1: # 0이어도 안되고 2여도 안됨 (모든 홈을 채워야 하므로)
                return False

    return True

def solution(key, lock):
    start = len(key) - 1  # expendList에서 lock의 시작 지점
    end = start + len(lock)  # expendList에서 lock이 끝나는 지점
    expendSize = len(lock) + start * 2  # expendList 배열의 크기

    # lock 고정, key 움직임
    for a in range(0, 4): # 바로 안 열리면 90도 돌리고 다시 실행
        for i in range(end):
            for j in range(end):
                if check(i, j, key, lock, expendSize, start, end):
                    return True
        key = rotation(key)

    return False