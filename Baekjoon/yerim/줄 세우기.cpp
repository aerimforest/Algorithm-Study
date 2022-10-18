// [2252] 줄 세우기
// 일반적으로 위상정렬의 결과는 유일하지 않음
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M, inDegree[32001], order[32001];
vector<int> vec[32001];

void input()
{
    int small, tall;
    cin >> N >> M;
    for(int i = 0; i < M; i++) {
        cin >> small >> tall;
        vec[small].push_back(tall);
        inDegree[tall]++;
    }
}

void solve()
{
    int idx = 0; // 위치
    queue<int> q;
    // init
    for(int i = 1; i <= N; i++) {
        if(inDegree[i] == 0) {
            q.push(i);
        }
    }

    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        order[idx++] = cur; // 현재 위치에 cur번 학생 세움
        for(int next: vec[cur]) {
            // next를 가리키고 있던 간선 하나가 사라졌으므로(cur) inDegree 1 감소
            if(--inDegree[next] == 0) {
                q.push(next);
            }
        }
    }
}

void output()
{
    for(int i = 0; i < N; i++) {
        cout << order[i] << ' ';
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