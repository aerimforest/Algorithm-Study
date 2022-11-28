// [15686] 치킨 배달
#include <iostream>
#include <vector>
#include <cmath>
#define MAX 987654321
using namespace std;

int N, M, ans = MAX; 
bool isSelected[13];
struct Pos {
    int x;
    int y;
};
vector<Pos> house, chickenShop, selectedShop;

void input()
{
    int tmp;
    cin >> N >> M;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> tmp;
            if(tmp == 1)
                house.push_back({ i, j });
            else if(tmp == 2)
                chickenShop.push_back({ i, j });
        }
    }
}

int getDistance(Pos a, Pos b)
{
    return abs(a.x - b.x) + abs(a.y - b.y);
}

void getMinDistance()
{
    int result = 0;
    for(int i = 0; i < house.size(); i++) {
        int minDist = MAX;
        for(int j = 0; j < selectedShop.size(); j++) {
            minDist = min(minDist, getDistance(house[i], selectedShop[j])); 
        }
        result += minDist; 
    }
    ans = min(ans, result);
}

void selectChickenShop(int x, int cnt)
{
    if(cnt == M) { 
        getMinDistance();
    }

    for(int i = x; i < chickenShop.size(); i++) {
        if(isSelected[i] == true)
            continue; 

        isSelected[i] = true;
        selectedShop.push_back({ chickenShop[i].x, chickenShop[i].y });
        selectChickenShop(i, cnt + 1);
        isSelected[i] = false;
        selectedShop.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    selectChickenShop(0, 0);
    cout << ans << '\n';
    
    return 0;
}