// [16967] 배열 복원하기
#include <iostream>
using namespace std;

int h, w, x, y, a[300][300], b[600][600];

void input()
{
    cin >> h >> w >> x >> y;
    for(int i = 0; i < h + x; i++) {
        for(int j = 0; j < w + y; j++) {
            cin >> b[i][j];
        }
    }
}

void solve()
{
    // 겹치지 않는 부분
    for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
            a[i][j] = b[i][j];
        }
    }

    // 겹치는 부분
    for(int i = x; i < h; i++) {
        for(int j = y; j < w; j++) {
            a[i][j] = b[i][j] - a[i - x][j - y];
        }
    }
}

void output()
{
    for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
    output();

    return 0;
}