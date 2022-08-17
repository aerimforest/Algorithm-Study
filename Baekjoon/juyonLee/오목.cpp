#include <iostream>
#define MAX 19

using namespace std;

char arr[MAX][MAX];
int moving[4][2] = { {0, 1},{1, 0},{1, 1},{-1, 1} };
bool visited[MAX][MAX][4][2];

char dfs(int r, int c, int dir, char color, int cnt) 
{
	visited[r][c][dir][color - '1'] = true;
	int nR = r + moving[dir][0];
	int nC = c + moving[dir][1];
	if (nR < 0 || nR >= MAX || nC < 0 || nC >= MAX || arr[nR][nC] != color) 
    {
		if (cnt == 5) 
        {
			return color;
		}
		else {
			return '0';
		}
	}
	return dfs(nR, nC, dir, color, cnt + 1);
	
}

int main() 
{
	ios::sync_with_stdio(false);
	cin.tie(0);

	for (int i = 0; i < MAX; i++) 
    {
		for(int j=0; j<MAX; j++)
        {
			cin>>arr[i][j];
		}
	}
	
	for (int i = 0; i < MAX; i++) 
    {
		for (int j = 0; j < MAX; j++) 
        {
			if (arr[j][i] != '0') 
            {
				for (int dir = 0; dir < 4; dir++) 
                {
					if (visited[j][i][dir][arr[j][i] - '1'])
                        continue;
					if (dfs(j, i, dir, arr[j][i], 1) != '0') 
                    {
						cout << arr[j][i] << '\n' << j + 1 << ' ' << i + 1;
						return 0;
					}
				}
			}
		}
	}
		
	cout << 0;
	
    return 0;
}



/*
오른쪽 / 위 / 위쪽 대각선 / 아래쪽 대각선으로 찾았는데 틀린 코드..추후 수정 필요
bool check(int i, int j)
{
    return (1 <= i && i < MAX) && (1 <= j && j < MAX);
}

bool upCross(int i, int j)
{
    if(check(i + 1, j - 1) && (arr[i][j] == arr[i + 1][j - 1]))
        return false;
    for(int k = 1; k <= 4; k++)
    {
        if(!check(i - k, j + k) || arr[i][j] != arr[i - k][j + k])
            return false;
    }
    if(check(i - 5, j + 5) && arr[i][j] == arr[i - 5][j + 5])
        return false;
    return true;
}

bool downCross(int i, int j)
{
    if(check(i - 1, j - 1) && arr[i][j] == arr[i - 1][j - 1])
        return false;
    for(int k = 1; k <= 4; k++)
    {
        if(!check(i + k, j + k) || arr[i][j] != arr[i + k][j + k])
            return false;
    }

    if(check(i + 5, j + 5) && arr[i][j] == arr[i + 5][j + 5])
        return false;
    return true;
}

bool row(int i, int j)
{
    if(check(i, j - 1) && (arr[i][j] == arr[i][j - 1]))
        return false;
    for(int k = 1; k <= 4; i++)
    {
        if(!check(i, j + k) || arr[i][j] == arr[i][j + k])
            return false;
    }
    if(check(i, j + 5) && arr[i][j] == arr[i][j + 5])
        return false;

    return true;
}

bool col(int i, int j)
{
    if(check(i - 1, j) && (arr[i][j] == arr[i - 1][j]))
        return false;
    for(int k = 1; k <= 4; k++)
    {
        if((check(i + k, j) == false) || arr[i][j] == arr[i + k][j])
            return false;
    }
    if(check(i + 5, j) && arr[i][j] == arr[i + 5][j])
        return false;
    return true;
}

int main()
{
    ios_base::sync_with_stdio(0);
	cin.tie(0);
    for(int i = 1; i < MAX; i++)
    {
        for(int j = 1; j < MAX; j++)
        {
            cin >> arr[i][j];
        }
    }

    for(int i = 1; i < MAX; i++)
    {
        for(int j = 1; j < MAX; j++ )
        {
            if(arr[i][j] != 0)
            {
                if(row(i, j) || col(i, j) || upCross(i, j) || downCross(i, j))
                {
                    cout << arr[i][j] << '\n';
                    cout << i << " " << j << '\n';
                    return 0;
                }
            }
        }
    }

    cout << 0 << '\n';
    //완전탐색
}

*/
