//16235

#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
#include <cstring>
#define MAX 11
using namespace std;

int N, M, K;

int arr[MAX][MAX], nutArr[MAX][MAX], deathArr[MAX][MAX];

vector<int> v[MAX][MAX];

void spring()
{
    memset(deathArr, 0, sizeof(deathArr)); 

    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            if(v[i][j].size()) 
            {
                sort(v[i][j].begin(), v[i][j].end()); 

                vector<int> v2; 

                for(int k = 0; k < v[i][j].size(); k++)
                {
                    int treeAge = v[i][j][k];
                    if(arr[i][j] >= treeAge) 
                    { 
                        arr[i][j] -= treeAge;
                        v2.push_back(v[i][j][k] + 1); 

                    } 
                    
                    else
                    { 
                        deathArr[i][j] += (treeAge / 2); 
                    }
                }

                v[i][j].clear();
                v[i][j] = v2;  
            }
        }
    }
    return;
}

void summer()
{
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            arr[i][j] += deathArr[i][j]; 
        }
    }
    return;
}


void fall()
{
    int dx[] = {-1, 0, 0, 1, -1, -1, 1, 1};
    int dy[] = {0, -1, 1, 0, -1, 1, -1, 1};
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            for(int k = 0; k < v[i][j].size(); k++)
            {
                if(v[i][j][k] % 5 == 0) 
                {
                    for(int l = 0; l < 8; l++)
                    {
                        int nx = i + dx[l];
                        int ny = j + dy[l];

                        if(nx < 1 || ny < 1 || nx > N || ny > N) 
                            continue;

                        v[nx][ny].push_back(1);
                    }
                }
            }
        }
    }
    return;
}


void winter()
{
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            arr[i][j] += nutArr[i][j];
        }
    }
    return;
}


int main()
{
    cin >> N >> M >> K;
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            arr[i][j] = 5;
            cin >> nutArr[i][j]; 
        }
    }

    int x, y, z;

    for(int i = 1; i <= M; i++)
    {
        cin >> x >> y >> z;
        v[x][y].push_back(z); 
    }

    for(int i = 1; i <= K; i++)
    {
        spring();
        summer();
        fall();
        winter();
    }

    int ans = 0;

    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            ans += v[i][j].size();
        }
    }
    cout << ans;
}
