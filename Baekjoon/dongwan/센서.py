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
print(arr)

print(sum(arr[:N-K]))

# 1 40 100 
# 39 60
# sensors = [1,3,9,10]
# for i in range(1,11) :
#     cnt = 0
#     for sensor in sensors :
#         cnt+=abs(sensor-i)
#     print(cnt)

# sensors = [1, 6, 9, 3, 6, 7]
# for x in range(1,10) :
#     for y in range(1,10) : 
#         cnt = 0
#         for sensor in sensors :
#             t1 = abs(sensor-x)
#             t2 = abs(sensor-y)
#             cnt+=min(t1,t2)
#         print(cnt,x,y)
# print(cnt)

# 1 2 3 4 5 6 7 8 9 
#   x         x
# sensors = [1, 6, 9, 3, 6, 7]

# cnt = 0
# x,y=2,7
# for sensor in sensors :
#     t1 = abs(sensor-x)
#     t2 = abs(sensor-y)
#     print(t1,t2,sensor)
#     cnt+=min(t1,t2)
# print(cnt)

# # 1 2 3 4 5 6 7 8 9 
#   x         x