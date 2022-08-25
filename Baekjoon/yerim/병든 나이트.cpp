// [1783] 병든 나이트
#include <iostream>
using namespace std;

int startTravel(int n, int m)
{
    if(n == 1) return 1; // 처음 있었던 위치
    else if(n == 2) return min(4, (m + 1) / 2); // 세로가 2인 경우 1, 4번 이동은 사용 불가 -> 최대 4칸 방문 가능
    else if(m < 7) return min(4, m); // 세로 >= 3이어도 가로 < 7인 경우 1~4 모두 사용은 불가 -> 최대 4칸 방문 가능
    else return 5 + (m - 7); // 세로 >= 3 & 가로 >= 7인 경우 1~4 모두 사용 가능 -> 기본으로 5칸 방문 가능 + 알파
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    cout << startTravel(n, m) << '\n';

    return 0;
}