// [9205] 맥주 마시면서 걸어가기
#include <iostream>
#include <queue>
#include <cmath>
#include <cstring>
using namespace std;

bool visited[101];
int store[101][2];
int n, homeX, homeY, festX, festY;

void bfs()
{
    queue<pair<int, int>> q;
    q.push(make_pair(homeX, homeY));
    memset(visited, false, sizeof(visited));
    
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        if(abs(x - festX) + abs(y - festY) <= 1000) {
            cout << "happy\n";
            return;
        }
        for(int i = 0; i < n; i++) {
            int dist = abs(x - store[i][0]) + abs(y - store[i][1]);
            if(dist <= 1000 && visited[i] == false) {
                q.push(make_pair(store[i][0], store[i][1]));
                visited[i] = true;
            }
        }
    }
    cout << "sad\n";
}

void input()
{
    int t;
    cin >> t;
    while(t--) {
        cin >> n;
        cin >> homeX >> homeY;
        for(int i = 0; i < n; i++) {
            cin >> store[i][0] >> store[i][1];
        }  
        cin >> festX >> festY; 
        bfs();
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}