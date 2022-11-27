// [2210] 숫자판 점프
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int digitBoard[6][6];
int dx[4] = { 1, 0, -1, 0 }, dy[4] = { 0, -1, 0, 1 };
vector <int> ans;

void input()
{
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            cin >> digitBoard[i][j];
        }
    }
}

void dfs(int x, int y, int num, int length)
{
    if(length == 6) {
        ans.push_back(num);
        return;
    }

    for (int i = 0; i < 4; i++) { 
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
			dfs(nx, ny, num*10 + digitBoard[nx][ny], length + 1); 
		}
	}
}

int makeNum()
{
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            dfs(i, j, digitBoard[i][j], 1);          
        }
    }
    sort(ans.begin(), ans.end()); 
	ans.erase(unique(ans.begin(), ans.end()), ans.end());

    return ans.size();
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    cout << makeNum() << '\n';

    return 0;
}