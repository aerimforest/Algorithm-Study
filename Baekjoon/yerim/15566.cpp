// [15566] 개구리 1
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m, interest[16][5], lotus[16][2];
vector<int> order;
vector<pair<int, int>> vec[16];

void input()
{
    int a, b, t;
    cin >> n >> m;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= 4; j++) {
            cin >> interest[i][j];
        }
    }
    for(int i = 1; i <= n; i++) {
        cin >> lotus[i][0] >> lotus[i][1];
    }
    for(int i = 0; i < m; i++) {
        cin >> a >> b >> t;
        vec[a].push_back({b, t});
    }
}

void printAns()
{
    cout << "YES\n";
    for(int i = 0; i < order.size(); i++) {
        cout << order[i] << " ";
    }
    cout << '\n';
}   

void solve()
{
    for(int i = 1; i <= n; i++) {
        order.push_back(i);
    }
    do {
        cout << "\nnew case\n";
        for(int i = 0; i < order.size(); i++) {
            cout << order[i] << " ";
        }
        cout << '\n';
        // 선호하는 자리에 있는지 체크
        bool flag = true;
        for(int i = 1; i <= n; i++) {
            if(i != lotus[order[i]][0] && i != lotus[order[i]][1]) {
                flag = false;
                break;
            }
        } 
        // 모두 선호하는 자리에 있다면 대화 주제 일치 여부 체크
        if(flag == true) {
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < vec[i].size(); j++) {
                    int topic = vec[i][j].second;
                    if(interest[i][topic] != interest[vec[i][j].first][topic]) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(flag == true) {
            printAns();
            return;
        }
    } while (next_permutation(order.begin(), order.end()));
    
    // 가능한 배치 방법이 없다면 
    cout << "NO\n";
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}