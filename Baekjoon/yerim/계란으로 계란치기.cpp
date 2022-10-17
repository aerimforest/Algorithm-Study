// [16987] 계란으로 계란치기
#include<iostream>
using namespace std;
 
int N, ans, weight[9], duration[9];
 
void input()
{
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> duration[i] >> weight[i];
    }
}
 
void dfs(int idx)
{
    if (idx >= N) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (duration[i] <= 0) cnt++;
        }
        if (ans < cnt) ans = cnt;
        return;
    }
 
    if (duration[idx] <= 0) dfs(idx + 1);
    else {
        bool flag = false;       
        for (int i = 0; i < N; i++) {
            if (i == idx || duration[i] <= 0) continue;
 
            duration[idx] = duration[idx] - weight[i];
            duration[i] = duration[i] - weight[idx];
            flag = true;
            dfs(idx + 1);
            duration[i] = duration[i] + weight[idx];
            duration[idx] = duration[idx] + weight[i];
        }
        if (flag == false) dfs(N);
    }
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    input();
    dfs(0);
    cout << ans << '\n';
 
    return 0;
}