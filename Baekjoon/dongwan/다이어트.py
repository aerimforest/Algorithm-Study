G = int(input())

# G = 현재 몸무게**2 - (성원이 기억 몸무게)**

now = [i for i in range(1,100001)]
think = [i for i in range(1,100001)]

N,M = 100000,100000
left, right = 0,0 

answer = []

while left<N and right <N :
    #G 추정 
    candidate = now[left]**2 - think[right]**2 
    #일치하면 정답에 추가 
    if candidate == G :
        answer.append(now[left])
    
    #G보다 작으면 현재 몸무게에 +=1  
    elif candidate < G :
        left += 1 
        continue
    #G보다 크면 더 만은 수를 빼야하니 right += 1 
    right += 1 
if answer :
    for ans in answer :
        print(ans)
else :
    print(-1)

