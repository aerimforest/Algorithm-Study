// [2502] 떡 먹는 호랑이
#include <iostream>
using namespace std;

int d, k, day1day2Cnt[31][2];

void input()
{
    cin >> d >> k;
}

void getTteokCnt(int x, int y)
{
    /* ex) 6일째: (첫째날 떡의 개수 * 3) + (둘째날 떡의 개수 * 5) = 41
           -> 3x + 5y = 41을 만족하는 x, y 찾기 */
    for(int i = 1; ; i++) {
        if((k - x*i) % y == 0) {
            cout << i << '\n';
            cout << (k - x*i) / y << '\n';
            return;
        }
    } 
}

void getCrossDay()
{
    day1day2Cnt[3][0] = 1; day1day2Cnt[3][1] = 1;
    day1day2Cnt[4][0] = 1; day1day2Cnt[4][1] = 2;

    for(int i = 5; i <= d; i++) {
        day1day2Cnt[i][0] = day1day2Cnt[i-1][0] + day1day2Cnt[i-2][0];
        day1day2Cnt[i][1] = day1day2Cnt[i-1][1] + day1day2Cnt[i-2][1];
    }

    getTteokCnt(day1day2Cnt[d][0], day1day2Cnt[d][1]);
}

int main(void)
{
    input();
    getCrossDay();

    return 0;
}