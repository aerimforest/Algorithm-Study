inputs = input().split('-')
answer = 0

for i in inputs[0].split('+'):
    answer += int(i)

for i in inputs[1:]: # 이 뒤로는 계속 빼주기
    for j in i.split('+'):
        answer -= int(j)

print(answer)