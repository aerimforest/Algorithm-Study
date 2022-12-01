// [6987] 월드컵
#include <iostream>
using namespace std;
 
int tmpResult[6][3], result[6][3], ans[4];
int team1[15] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
int team2[15] = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
 
void dfs(int T, int round)
{
    if(round == 15) {
        if(ans[T]) return;
 
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 3; c++) {
                if(tmpResult[r][c] != result[r][c]) {
                    return;
                }
            }
        }  
        ans[T] = 1;
        return;
    }
            
    int t1 = team1[round];
    int t2 = team2[round];
 
    result[t1][0]++; result[t2][2]++;
    dfs(T, round + 1);
    result[t1][0]--; result[t2][2]--;
 
    result[t1][1]++; result[t2][1]++;
    dfs(T, round + 1);
    result[t1][1]--; result[t2][1]--;
 
    result[t1][2]++; result[t2][0]++;
    dfs(T, round + 1);
    result[t1][2]--; result[t2][0]--;
}

void input()
{
    for(int T = 0; T < 4; T++) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 3; j++) {
                cin >> tmpResult[i][j];
            }
        }
        dfs(T, 0);
    }
}

void output()
{
    for(int i = 0; i < 4; i++) {
        cout << ans[i] << ' ';
    }
    cout << '\n';
}
 
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); 

    input();
    output();

    return 0;
}