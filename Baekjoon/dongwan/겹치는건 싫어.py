from collections import defaultdict

n,k = map(int,input().split())

#숫자 목록 받기 
nums = list(map(int,input().split()))

#왼쪽 오른쪽 초기화, defaultdict 만들기 
left,right,dic = 0,0,defaultdict(int)

#정답 초기화
ans = 0

#오른쪽 끝까지 가지 않았다면 
while right < n :

    #현재 nums의 right번째 수가 k보다 작게 식별되면 
    if dic[nums[right]] < k :
        #숫자를 올리고 
        dic[nums[right]] += 1
        #연속수열로 한칸더감  
        right += 1 
    #nums의 right번째가 k보다 같아지면 

    else :
        #왼쪽을 계속 늘리면서 해당 숫자를 찾을때까지 감 
        dic[nums[left]] -=1 
        left += 1 
    ans = max(ans,right-left)
print(ans)