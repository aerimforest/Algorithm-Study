#include <string>
#include <vector>
#include <queue>

using namespace std;

const int INF = 987654321;
vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits)
{
    // init
    int D[n + 1][n + 1];
    for (int i = 1; i <= n; ++i)
    {
        for (int j = 1; j <= n; ++j)
        {
            D[i][j] = INF;
        }
        D[i][i] = 0;
    }

    for (vector<int> p : paths)
    {
        D[p[0]][p[1]] = min(D[p[0]][p[1]], p[2]);
        D[p[1]][p[0]] = min(D[p[1]][p[0]], p[2]);
    }

    for (int k = 1; k <= n; ++k)
    {
        for (int i = 1; i <= n; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                D[i][j] = min(D[i][j], max(D[i][k], D[k][j]));
            }
        }
    }

    vector<int> answer = {0, INF};
    for (int g : gates)
    {
        for (int s : summits)
        {
            if (answer[1] > D[g][s])
            {
                answer = {s, D[g][s]};
            }
            else if (answer[1] == D[g][s] && answer[0] > s)
            {
                answer = {s, D[g][s]};
            }
        }
    }

    return answer;
}
