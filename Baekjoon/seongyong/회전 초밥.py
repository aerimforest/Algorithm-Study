import sys
from collections import defaultdict

def solve():
    left = 0
    right = 0
    dict = defaultdict(int)
    result = 0
    # k만큼 먹기
    while right < k:
        dict[arr[right]] += 1
        right += 1

    # c는 반드시 추가
    dict[c] += 1

    # 슬라이딩 윈도우
    while left < n:
        result = max(result, len(dict))
        # 1. 맨 왼쪽 초밥 제거
        dict[arr[left]] -= 1
        # 삭제된 왼쪽 초밥이 0 이면 dict 삭제
        if dict[arr[left]] == 0:
            del dict[arr[left]]
        dict[arr[right % n]] += 1
        left += 1
        right += 1

    print(result)
    return

if __name__ == "__main__":
    n, d, k, c = map(int, sys.stdin.readline().split())
    arr = [int(sys.stdin.readline()) for _ in range(n)]
    solve()
