N = int(input())
K = int(input())
if K >= N:
    print(0)
    exit()
sensors = list(map(int,input().split()))

sensors.sort()
# print(sen/sor/s)
arr=  []

for i in range(N-1) :
    arr.append(sensors[i+1]-sensors[i])
arr.sort()
# print(arr)

print(sum(arr[:N-K]))

# 1 40 100 
# 39 60