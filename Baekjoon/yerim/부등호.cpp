// [2529] 부등호
// 2208KB, 144ms
#include <iostream>
#include <cmath>
using namespace std;

bool visited[10];
char sign[10];
int k, tmpNum[10];
long long maxNum = 0, minNum = 9876543210;

void input()
{
    cin >> k;
    for(int i = 0; i < k; i++) {
        cin >> sign[i];
    }
}

bool check()
{
    for(int i = 0; i < k; i++) {
        if(tmpNum[i] < tmpNum[i+1] && sign[i] == '>') {
            return false;
        }
        else if(tmpNum[i] > tmpNum[i+1] && sign[i] == '<') return false;
    }
    return true;
}

void update()
{
    long long num = 0, idx = 1;
    for(int i = k; i >= 0; i--) {
        num += tmpNum[i] * idx;
        idx *= 10;
    }
    if(num > maxNum) maxNum = num;
    if(num < minNum) minNum = num;
}

void dfs(int idx, int depth)
{
    if(depth == k + 1) {
        if(check() == true) {
            update();
        }
        return;
    }
    for(int i = 0; i < 10; i++) {
        if(visited[i] == false && i != idx) {
            visited[i] = true;
            tmpNum[depth] = i;
            dfs(i, depth + 1);
            visited[i] = false;
        }
    }
}

void output()
{
    if(maxNum < pow(10, k)) cout << "0";
    cout << maxNum << '\n';

    if(minNum < pow(10, k)) cout << "0";
    cout << minNum << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    dfs(-1, 0);
    output();

    return 0;
}