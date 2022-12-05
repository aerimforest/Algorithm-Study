// [14676] 영우는 사기꾼?
#include <iostream>
#include <vector>
using namespace std;

bool cheat;
int n, m, k;
int inDegree[100001], built[100001];
vector <int> child[100001];

void input()
{
    int x, y;
    cin >> n >> m >> k;
    for(int i = 0; i < m; i++) {
        cin >> x >> y;
        child[x].push_back(y);
        inDegree[y]++;
    }
}

void solve()
{
    int state, node;
    for(int i = 0; i < k; i++) {
        cin >> state >> node;

        if(cheat) continue;
        if(state == 1) { 
            if(inDegree[node]) cheat = true; // 이전 건물이 안지어진 경우
            else{
                if(built[node]++) continue; // 이미 지어진 경우
                for(int next : child[node]) inDegree[next]--;
            }
        }
        else {
            if(built[node] == 0) cheat = true; // 안지어진 건물을 파괴하려는 경우
            else {
                built[node]--;
                if(built[node] > 0) continue;
                for(int next : child[node]) inDegree[next]++;
            }
        }

    }
}

void output()
{
    if(cheat) cout << "Lier!\n";
    else cout << "King-God-Emperor\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
    output();

    return 0;
}