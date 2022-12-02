// [1707] 이분 그래프
// 그래프, dfs, bfs
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

vector<int> list[200001];
int v, visited[200001];
bool ans = true;

void bipartite(int start)
{   
    queue<int> q;
    visited[start] = 1; 
    q.push(start); 

    while (!q.empty()) { 
        int x = q.front(); q.pop(); 
        for (int i = 0; i < list[x].size(); i++) { 
            int next = list[x][i]; 
            if (visited[next] == 0) { 
                visited[next] = 3 - visited[x];
                q.push(next); 
            } 
            else {
                if(visited[next] != 3 - visited[x]) {
                    ans = false;
                } 
            }
        } 
    } 
}

void initialize(int n)
{
    memset(visited, 0, sizeof(visited));
    list->clear();
    for(int i = 0 ; i <= n ; i++) {
        list[i].clear();
    }
    ans = true;
}   

void solve()
{
    for(int i = 1 ; i <= v ; i++) {
        if(visited[i] == 0) {
            ans = true;
            bipartite(i);
            if(ans == false) {
                cout << "NO" << '\n';
                break;
            }
        }
    }

    if(ans == true) cout << "YES" << '\n';
}

void input()
{
    int k, e, v1, v2;
    cin >> k;
    while(k--) {
        cin >> v >> e;
        initialize(v);

        for(int i = 0 ; i < e ; i++) {
            cin >> v1 >> v2;
            list[v1].push_back(v2); list[v2].push_back(v1);
        }

        solve();
    }
}

int main(void)
{
    input();
    return 0;
}