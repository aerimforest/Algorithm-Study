// [10971] 외판원 순회 2
#include <iostream>
using namespace std;

int n, w[11][11], minSum = 1e9, sum = 0, cnt = 0, start = 0;
bool visited[11];

void dfs(int curr)
{
    visited[curr] = true;
    if(cnt == n) { // 모든 노드를 방문했고
        if(w[curr][start]) { // 현재 위치에서 처음 위치로 바로 이동할 수 있다면
            minSum = sum + w[curr][start] < minSum ? sum + w[curr][start] : minSum; // 최소 비용 갱신
        }
        return;
    }

    for(int i = 1 ; i <= n ; i++) {
        if(w[curr][i] > 0 && visited[i] == false) { // 경로가 있고 방문한 적 없다면
            //visited[i] = true;
            cnt++; sum += w[curr][i];
            dfs(i); 
            visited[i] = false;
            cnt--; sum -= w[curr][i];
        }
    }
}

int main(void)
{
    cin >> n;

    for(int i =  1 ; i <= n ; i++) {
        for(int j = 1 ; j <= n ; j++) {
            cin >> w[i][j];
        }
    }

    for(int i = 1 ; i <= n ; i++) {
        start = i; // 시작 노드
        sum = 0; cnt = 1; // 초기화
        dfs(i);
        visited[i] = false;
    }

    cout << minSum << '\n';
    return 0;
}