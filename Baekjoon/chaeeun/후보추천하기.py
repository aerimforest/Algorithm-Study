#(참고)

n = int(input()) # 액자 수
candidate = int(input()) # 전체 학생의 추천 수
votes = list(map(int, input().split())) # 추천한 후보
results = [] # 결과 액자
cnts = [] # 추천받은 횟수 임시저장용

for i in votes:
    if i in results: ## 이미 액자에 학생이 있는 경우
        cnts[results.index(i)] += 1
    else: ## 새로 등록된 후보인 경우
        if len(results) >= n: ## 액자가 꽉 찬 경우
            idx = cnts.index(min(cnts))
            del results[idx]
            del cnts[idx]
        results.append(i)
        cnts.append(1)

results.sort()
print(' '.join(map(str, results)))