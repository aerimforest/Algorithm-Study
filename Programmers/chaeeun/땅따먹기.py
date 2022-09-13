def solution(land):

  for i in range(1, len(land)): # 행 인덱스
    for j in range(4): # 열 인덱스 - 모두 4열로 이루어져 있음
      land[i][j] += max(land[i-1][0:j] + land[i-1][j+1:])

  return max(land[-1])