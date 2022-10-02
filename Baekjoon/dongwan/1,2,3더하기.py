t = int(input())

answer = []
for _ in range(t) :
    dp1,dp2,dp3 = 1,2,4
    target = int(input())
    if target == 1 :
        print(1)
        continue
    elif target == 2 :
        print(2)
        continue
    elif target==3 :
        print(4)
        continue
    for i in range(3,target) :
        tmp = dp1+dp2+dp3 
        dp1,dp2,dp3 = dp2,dp3,tmp
    print(tmp)
#ax+by+c = 44
#2a+4b+c = 7
#a+2b+c = 4
#a+2b = 3 ; c=1
#4a+7b+1 = 13
#4a+8b = 12 
# b =3
# a= -3
# x = -3x+3y+1 
# 1 = 1
# 2 = 2 
# 3 = 4 
# 4 = 7
# 11111 1112*4 113*3 122*3 23*2 
# 5 = 13
# 6 = 24
# 7 = 44 
# 8 
# 9
# 10 = 274