#include <string>
#include <vector>
#include <queue>

using namespace std;

int V[50001]; // 0: 쉼터 1: 출입구 2: 산봉우리
struct peak
{
    int cur, intensity;

    bool operator<(const peak &x) const
    {
        return this->intensity > x.intensity;
    }
};
vector<peak> E[50001];
int D[50001];
const int INF = 987654321;

vector<int>
solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits)
{
    // init
    for (vector<int> path : paths)
    {
        E[path[0]].push_back({path[1], path[2]});
        E[path[1]].push_back({path[0], path[2]});
    }
    for (int g : gates)
    {
        V[g] = 1;
    }
    for (int s : summits)
    {
        V[s] = 2;
    }

    // summit -> gate
    vector<int> answer = {0, INF};
    for (int s : summits)
    {
        for (int i = 1; i <= n; ++i)
        {
            D[i] = INF;
        }
        priority_queue<peak> pq;

        D[s] = 0;
        pq.push({s, 0});

        while (!pq.empty())
        {
            int cur = pq.top().cur, intensity = pq.top().intensity;
            pq.pop();

            if (V[cur] == 1)
            {
                if (answer[1] > intensity)
                {
                    answer = {s, intensity};
                }
                else if (answer[1] == intensity && answer[0] > s)
                {
                    answer = {s, intensity};
                }

                break;
            }

            for (peak next : E[cur])
            {
                if (V[next.cur] != 2 && D[next.cur] > max(intensity, next.intensity))
                {
                    D[next.cur] = max(intensity, next.intensity);
                    pq.push({next.cur, D[next.cur]});
                }
            }
        }
    }

    return answer;
}
