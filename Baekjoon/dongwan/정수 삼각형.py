n=int(input())
dp=[]
#dp에 싹 넣기 
for i in range(n):
    dp.append(list(map(int, input().split())))

#높이를 돌면서  
for i in range(1,n):
    #해당 행의 열들을 돌면서 
    for j in range(len(dp[i])):
        #처음건 비교할게 없이 위랑 더하기
        if j==0:
            dp[i][j]=dp[i][j]+dp[i-1][j]
        #마지막것도 비교할게 없이 위랑 더하기
        elif j==len(dp[i])-1: 
            dp[i][j]=dp[i][j]+dp[i-1][j-1]
        #아니라면 위에서 더 컸던거와 비교
        else:
            dp[i][j]=max(dp[i-1][j-1],dp[i-1][j])+dp[i][j]
print(max(dp[n-1]))