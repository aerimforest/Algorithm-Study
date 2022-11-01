x,y,c = map(float,input().split())

#x와 y가만나는 지점 c
#x,y는 삼각형의 대각선 

#도출할 값 res = 밑변 

#밑변 * c = 끼인 

#h1 = (x**2-ans**2)**0.5
#h2 = (y**2-ans**2)**0.5

start,end = 0,min(x,y)

ans = 0

def solution(x,y,res) :
    h1 = (x**2-res**2)**0.5
    h2 = (y**2-res**2)**0.5
    tmp_ans = h1*h2/(h1+h2)
    return tmp_ans
while end-start > 0.000001 :
    m = (start+end)/2 

    if solution(x,y,m) >= c :
        ans = m 
        start = m
    else :
        end = m

print("%.3f"%round(ans,3))