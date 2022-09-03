//17822

#include <iostream>
#include <vector>
#include <cstring>

#define MAX 51
using namespace std;

int a[MAX][MAX];

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int main()
{
	int n, m, t;
	cin >> n >> m >> t;

	for(int i = 0; i < n; i++)
    {
		for(int j=0; j<m; j++)
        {
			cin >> a[i][j];
        }
    
    }

	for(int i = 0; i < t; i++){
		int xi, di, ki;

		cin >> xi >> di >> ki;

		for(int j = xi; j <= n; j +=xi)
        {
			int b[m];

			memset(b, 0, sizeof(b));
			
            if(di == 0)
            {
				for(int idx = 0; idx < m; idx++)
                {
					int tmp = (idx + ki)%m;
					b[tmp] = a[j - 1][idx];
				}

			} 
            else
            {
				for(int idx = 0; idx < m; idx++)
                {
					int tmp = (idx + ki) %m;
					b[idx] = a[j - 1][tmp];
				}
			}

			for(int idx = 0; idx < m; idx++)
            {
				a[j - 1][idx] = b[idx];
			}
		}

		bool same = false; 
		bool tmp[n][m]; 

		memset(tmp, 0, sizeof(tmp));

		for(int x = 0; x < n; x++)
        {
			for(int y = 0; y < m; y++)
            {
				bool flag = false;
				
                if(a[x][y] == 0) 
                    continue;
				
                for(int k = 0; k < 4; k++)
                {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if(nx < 0 || nx >= n) 
                        continue;

					if(ny == -1) 
                        ny = m - 1;

					if(ny == m) 
                        ny = 0;

					if(a[x][y] == a[nx][ny])
                    {
						flag = true;
						same = true;
						tmp[nx][ny] = 1;
					}
				}
				if(flag)
                {
					tmp[x][y] = 1;
				}
			}
		}

		for(int j = 0; j < n; j++)
        {
			for(int k = 0; k < m; k++)
            {
				if(tmp[j][k]) 
                    a[j][k] = 0;
			}
		}

		if(!same)
        {
			int sum = 0;
			int cnt = 0;
			for(int j = 0; j < n; j++)
            {
				for(int k = 0; k < m; k++)
                {
					if(a[j][k] != 0)
                    {
						sum += a[j][k];
						cnt++;
					}
				}
			}
			for(int j = 0; j < n; j++)
            {
				for(int k = 0; k < m; k++)
                {
					if(a[j][k] != 0)
                    {
						if(a[j][k] * cnt > sum) 
                            a[j][k] -= 1;
						
                        else if(a[j][k] * cnt < sum) 
                            a[j][k] += 1;
					}
				}
			}
		}
	}

	int ans = 0;
	for(int i = 0; i < n; i++)
    {
		for(int j = 0; j < m; j++)
			ans += a[i][j];
	}

	cout << ans << '\n';

	return 0;
}