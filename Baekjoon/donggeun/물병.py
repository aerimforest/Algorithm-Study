n,k = map(int,input().split())
cnt = n 
while True:
    if bin(cnt).removeprefix("0b").count("1") <= k:
        break
    cnt += 1

print(cnt-n)