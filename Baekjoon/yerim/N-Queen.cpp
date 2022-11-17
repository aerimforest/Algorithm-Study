// [9663] N-Queen
// 브루트포스, 백트래킹
#include <iostream>
using namespace std;

int n, ans = 0;
int chess[15]; // 체스가 i번째 행의 chess[i]열에 위치

bool check(int row, int column)
{
    for(int i = 0 ; i < row ; i++) {
        // 같은 열에 위치 or 대각선에 위치(|x 좌표 차이| == |y 좌표 차이|)
        if(chess[i] == column || abs(i - row) == abs(chess[i] - column)) {
            return false; 
        }
    }
    return true; 
}

void go(int row)
{
    if(row == n) { 
        ans++; 
    }
    else { 
        for(int i = 0 ; i < n ; i++) {
            if(check(row, i)) { 
                chess[row] = i; // row행 i열에 퀸 배치
                go(row + 1); // 다음 행 탐색
            }
        }
    }
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    go(0); 
    
    return 0;
}