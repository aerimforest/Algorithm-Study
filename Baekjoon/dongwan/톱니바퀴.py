t1 = list(map(int,input()))
t2 = list(map(int,input()))
t3 = list(map(int,input()))
t4 = list(map(int,input()))

k = int(input())

#맞닿은 부분은
#1번-> 2 
#2번 -> 2,-2 
#3번 -> 2,-2 
#4번 -> -2

def get_rotate(target) :
    if target == 1 :
        if t1[2] != t2[-2] :
            tmp.append([2,t2])
    elif target == 2 :
        if t1[2] != t2[-2] :
            tmp.append([1,t1])
        if t2[2] != t3[-2] :
            tmp.append([3,t3])
    elif target == 3 :
        if t2[2] != t3[-2] :
            tmp.append([2,t2])
        if t3[2] != t4[-2] :
            tmp.append([4,t4])
    else :
        if t3[2] != t4[-2] :
            tmp.append([3,t3])
    
print(t1,t2,t3,t4)
for rotation in range(k) :
    target,dir = map(int,input().split())
    
    tmp = []
    get_rotate(target) 
    for n,t in tmp :
        if dir == 1 :
            t = [t[-1]]+t[:7]
        else :
            t = t[1:] + [t[-1]]
        
        if n == 1 :
            t1 = t
        elif n == 2 :
            t2 = t
        elif n == 3 :
            t3 = t 
        else :
            t4 = t 
print(t1,t2,t3,t4)
ans = 0
if t1[0] :
    ans += 1 
if t2[0] :
    ans += 2 
if t3[0] :
    ans += 4 
if t4[0] :
    ans += 8
print(ans)
        