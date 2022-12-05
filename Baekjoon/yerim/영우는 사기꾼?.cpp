// [14676] 영우는 사기꾼?
#include <iostream>
#include <vector>
using namespace std;

bool flag = true;
int n, m, k, cnt[100001];
vector<int> parents[100001];

void check(int state, int node)
{
    if(state == 1) {
        for(int parent: parents[node]) {
            if(cnt[parent] == 0) { // 부모 노드가 건설되지 않음
                flag = false;
                break;
            }
        }
        if(flag) cnt[node]++;
    }
    else if(state == 2) {
        if(cnt[node] == 0) { // 건설되지 않았는데 파괴
            flag = false;
        }
        else {
            cnt[node]--;
        }
    }
}

void input()
{
    int x, y;
    cin >> n >> m >> k;
    for(int i = 0; i < m; i++) {
        cin >> x >> y;
        parents[y].push_back(x);
    }
    for(int i = 0; i < k; i++) {
        cin >> x >> y;
        check(x, y);
    }
}

void output()
{
    if(flag == false) cout << "Lier!\n";
    else cout << "King-God-Emperor\n";
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    output();

    return 0;
}