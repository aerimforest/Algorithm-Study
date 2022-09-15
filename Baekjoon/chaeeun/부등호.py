# (참고)

### input
n = int(input())
sign = list(input().split())

visited = [False] * 10 ## 방문 표시
max_answer, min_answer = "",""

def possible(i, j, k): ## 연산자 계산
  if k == '<':
    return i < j
  else:
    return i > j
  return True

def solve(cnt, str_num): ## 최댓값과 최솟값 구하기
  global max_answer, min_answer
  if cnt == n+1: ## 부등호의 개수+1 만큼 문자열이 구성 되었을 경우
    if not len(min_answer): ## 최솟값이 존재하지 않는다면
      min_answer = str_num ## 최솟값으로 추가
    else:
      max_answer = str_num ## 그 외에는 최댓값으로 추가
    return

  for i in range(10): ## 0부터 9까지 숫자를 1개씩 입력받기
    if not visited[i]: ## 아직 특정 숫자를 방문하지 않았을 때
      ## 문자열이 아직 존재하지 않거나, 계산이 가능한 경우
      if cnt == 0 or possible(str_num[-1], str(i), sign[cnt-1]): 
        visited[i] = True ## 방문 표시
        solve(cnt+1, str_num+str(i)) ## 문자열 개수 1개 추가
        visited[i] = False ## 방문 표시 제거

solve(0, "")

### output
print(max_answer)
print(min_answer)