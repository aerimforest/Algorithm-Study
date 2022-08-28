//12978
#include <vector>
#include <algorithm>
#include <queue>
#define MAX 51

using namespace std;

int roads[MAX][MAX];
int dp[MAX];
void dijkstra(int start,int N)
{
    dp[1]=0;
    priority_queue<pair<int,int>, vector<pair<int,int>>,greater<pair<int,int>>> pq;
    pq.push({0,1});

    while(!pq.empty())
    {
       int cur= pq.top().second;
       int t = pq.top().first;
        pq.pop();
        if(dp[cur]<t)
            continue;

        for(int i = 0; i <= N; i++)
        {
            if(roads[cur][i] != 0)
            {
                int next = i;
                int ndir = t+ roads[cur][i];

                if(dp[next]>ndir)
                {
                    dp[next] = ndir;
                    pq.push({ndir,next});
                }
            }
        }

    }
}

int solution(int N, vector<vector<int> > road, int K) 
{
    int answer = 0;

    for(int i = 0; i < road.size(); i++)
    {
        int r = road[i][0];
        int c = road[i][1];
        int cost = road[i][2];

        if(roads[r][c] == 0){
        roads[r][c] = cost;
        roads[c][r] = cost;
        }

        else
        {
            roads[r][c] = min(roads[r][c], cost);
            roads[c][r] = min(roads[c][r], cost);
            }
    }

    for(int i = 0; i < MAX; i++)
    {
        dp[i]= 987654321 ;
    }

    dijkstra(1,N);

    for(int i = 1; i <= N; i++)
    {
        if(dp[i] <= K)
        {
            answer++;

        }
    }


    return answer;
}