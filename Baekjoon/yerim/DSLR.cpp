// [9019] DSLR
#include <iostream>
#include <queue>
#include <string>
#include <cstring>
using namespace std;

int a, b;
bool visited[10000];

void bfs()
{
    queue<pair<int, string>> q;
    q.push(make_pair(a, ""));
    visited[a] = true;

    while (!q.empty()) {
        int num = q.front().first;
        string command = q.front().second;
        q.pop();

        if (num == b) {
            cout << command << '\n';
            return;
        }

        int newNum;
        // D
        newNum = (num * 2) % 10000;
        if (!visited[newNum]) {
            visited[newNum] = true;
            q.push({newNum, command + "D"});
        }
        // S
        newNum = num - 1 < 0 ? 9999 : num - 1;
        if (!visited[newNum]) {
            visited[newNum] = true;
            q.push({newNum, command + "S"});
        }
        // L 
        newNum = (num % 1000) * 10 + (num / 1000);
        if (!visited[newNum]) {
            visited[newNum] = true;
            q.push({newNum, command + "L"});
        }
        // R 
        newNum = num / 10 + (num % 10) * 1000;
        if (!visited[newNum]) {
            visited[newNum] = true;
            q.push({newNum, command + "R"});
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        cin >> a >> b;
        memset(visited, false, sizeof(visited)); 
        bfs();
    }

    return 0;
}