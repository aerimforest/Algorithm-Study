dx = (1, 0, 1, 1, 2, 0)
dy = (0, 1, 1, -1, 0, 2)

def SocialDistance(x,y,place):
    check = True

    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        if not (0 <= nx < 5) or not (0 <= ny < 5) or place[ny][nx] != 'P':
            continue

        if i <= 1:
            check = False
            return check

        elif i == 2:
            if place[y+1][x] != 'X' or  place[y][x+1] != 'X':
                check = False
                return check

        elif i == 3:
            if place[y][x+1] != 'X' or place[y-1][x] != 'X':
                check = False
                return check

        elif i == 4:
            if place[y][x+1] != 'X':
                check = False
                return check

        elif i == 5:
            if place[y+1][x] != 'X':
                check = False
                return check
    return check

def solution(places):
    ans = []
    for place in places:
        followed = True
        for x in range(5):
            for y in range(5):
                if place[y][x] == 'P':
                    followed = SocialDistance(x,y,place)
                if not followed:
                    break
            if not followed:
                ans.append(0)
                break
        else:
            ans.append(1)

    return ans
