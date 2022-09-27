// [1992] 쿼드트리
#include <iostream>
using namespace std;

int n;
string quadTree[65], ans;

void input()
{
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> quadTree[i];
    }
}

void goSmallQuadTree(int x, int y, int gap)
{
    bool flag = true;
    for(int i = x; i < x + gap; i++) {
        for(int j = y; j < y + gap; j++) {
            if(quadTree[i][j] != quadTree[x][y]) {
                ans += '(';
                goSmallQuadTree(x, y, gap/2);
                goSmallQuadTree(x, y + gap/2, gap/2);
                goSmallQuadTree(x + gap/2, y, gap/2);
                goSmallQuadTree(x + gap/2, y + gap/2, gap/2);
                ans += ')';
                flag = false;
                break;
            }
        }
        if(flag == false) break;
    }
    if(flag == true) ans += quadTree[x][y];
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    goSmallQuadTree(0, 0, n);
    cout << ans << '\n';

    return 0;
}