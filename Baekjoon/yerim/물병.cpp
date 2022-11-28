// [1052] 물병
#include <iostream>
#include <vector>
using namespace std;

int n, k;
vector<int> vec;

void input()
{
    cin >> n >> k;
}

void combine()
{
    for(int i = 30; i >= 0; i--) {
        if(n == 0) break;
        else if(n >= (1 << i)){
            n -= (1 << i);
            vec.push_back(1 << i);
            i++;
        }
    }
}

void buyNewWater()
{
    int ans = 0;
    while(true) {
        int size = vec.size();
        if(vec[size - 2] != vec[size - 1]) {
            ans += (vec[size - 2] - vec[size - 1]);
            vec.push_back(vec[size - 2] - vec[size - 1]);
            size++;
        }
        vec[size - 2] += vec[size - 1];
        vec.pop_back(); size--;
        if(size <= k) {
            cout << ans << '\n';
            exit(0);
        }
    }
    cout << -1 << '\n';
}

void solve()
{
    combine();
    if(n % 2 != 0) vec.push_back(1);

    if(vec.size() > k) buyNewWater();
    else cout << 0 << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}