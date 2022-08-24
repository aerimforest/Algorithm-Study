#include <iostream>
#include <queue>
#define MAX 100

using namespace std;

int c, r, h, ans = 0;

int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};

int arr[MAX][MAX][MAX];
queue<pair<pair<int, int>, int> > q;

int main()
{
    ios::sync_with_stdio(false);
	cin.tie(0);

    cin >> c >> r >> h;

    for(int i = 0; i < h; i++)
    {
        for(int j = 0; j < r; j++)
        {
            for(int k = 0; k < c; k++)
            {
                cin >> arr[i][j][k];

                if(arr[i][j][k] == 1)
                    q.push({ {j, k}, i });
            }
        }
    }

    while(!q.empty())
    {
        ans+=1;
        int qsize = q.size();

        for(int i = 0; i < qsize; i++)
        {
            int row = q.front().first.first;
            int col = q.front().first.second;
            int height = q.front().second;

            q.pop();

            for(int j = 0; j < 6; j++)
            {
                int nrow = row + dx[j];
                int ncol = col + dy[j];
                int nheight = height + dz[j];

                if(nrow >= 0 && nrow <  r && ncol >= 0 && ncol < c && nheight >= 0 && nheight < h && arr[nheight][nrow][ncol] == 0)
                {
                    q.push({ {nrow, ncol}, nheight });
                    arr[nheight][nrow][ncol] = 1;

                }
                
            }
            
        }
    }

    for(int i = 0; i < h; i++)
    {
        for(int j = 0; j < r; j++)
        {
            for(int k = 0; k < c; k++)
            {
                if(arr[i][j][k] == 0)
                {
                    cout << -1 << '\n';
                    return 0;
                }
            }
        }
    }

    cout << ans-1 << '\n';
}
