from itertools import permutations

k = int(input())
signs = input().split()

result = []
for per in permutations([0,1,2,3,4,5,6,7,8,9],k+1) :
  flag = True
  for i in range(len(signs)) :
    if signs[i] == '<' :
      if per[i] < per[i+1] : continue
      else :
        flag = False
        break
    else :
      if per[i] > per[i+1] : continue
      else :
        flag = False
        break
  if flag :
    result.append(per)

print(''.join(map(str,list(max(result)))))
print(''.join(map(str,list(min(result)))))