// [1347] 미로 만들기
#include <iostream>
#include <algorithm>
using namespace std;

string str;
char map[110][110];
int leftEnd = 55, rightEnd = 55, bottomEnd = 55, topEnd = 55;

void init()
{
    for (int i = 0; i < 110; i++) {
        for (int j = 0; j < 110; j++) {
            map[i][j] = '#';
        }
    }
}

void solution()
{
    int x = 55, y = 55, dir = 2; 
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1}; 
	map[x][y] = '.';

	for (int i = 0; i < str.size(); i++) {
		if (str[i] == 'R') {
			dir++;
			if (dir > 3) dir = 0;
		}
		else if (str[i] == 'L') {
			dir--;
			if (dir < 0) dir = 3;
		}
		else {
			x += dx[dir]; y += dy[dir];
			map[x][y] = '.';
		}
		leftEnd = min(x, leftEnd);
        rightEnd = max(x, rightEnd);
        topEnd = min(y, topEnd);
		bottomEnd = max(y, bottomEnd);
	}
}

void output()
{
    for (int i = leftEnd; i <= rightEnd; i++) {
		for (int j = topEnd; j <= bottomEnd; j++) {
			cout << map[i][j];
		}
		cout << "\n";
	}
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
	cin >> n;
	cin >> str;
    
    init();
    solution();
    output();

    return 0;
}