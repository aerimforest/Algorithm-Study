# input - test 개수
test = int(input()) 

for i in range(test):
  coordinates = [] # x,y 좌표값들 받을 arr
  
  ## input - 편의점 개수 
  num_store = int(input()) 

  ## input - 집 좌표 
  coordinates.append(list(map(int, input().split())))

  ## input - 편의점(들) 좌표
  for i in range(num_store):
    coordinates.append(list(map(int, input().split())))

  ## input - 페스티벌 좌표
  coordinates.append(list(map(int, input().split())))

  distances = []
  for i in range(len(coordinates)-1, 0, -1):
    distances.append((coordinates[i][0] - coordinates[i-1][0]) + (coordinates[i][1] - coordinates[i-1][1]))

  answer = 0
  for distance in distances:
    if distance > 1000:
      answer += 1

  if answer == 0:
    print("happy")
  else:
    print("sad")