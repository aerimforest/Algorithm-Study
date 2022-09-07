#include <string>
#include <vector>

using namespace std;

vector<int> adj[20];
int answer;

void sol(int cur, vector<int> next, int sheep, int wolf, vector<int> info)
{
    if (info[cur])
    {
        wolf++;
    }
    else
    {
        sheep++;
    }

    if (wolf >= sheep)
    {
        return;
    }

    answer = max(answer, sheep);

    int len = next.size();
    for (int i = 0; i < len; ++i)
    {
        vector<int> nnext = next;
        nnext.erase(nnext.begin() + i);
        for (int n : adj[next[i]])
        {
            nnext.push_back(n);
        }
        sol(next[i], nnext, sheep, wolf, info);
    }
}
int solution(vector<int> info, vector<vector<int>> edges)
{
    for (vector<int> x : edges)
    {
        adj[x[0]].push_back(x[1]);
    }

    vector<int> next = adj[0];
    sol(0, next, 0, 0, info);

    return answer;
}
