#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> computers)
{
    int answer = 0;

    vector<bool> visit(n, false);
    for (int i = 0; i < n; ++i)
    {
        if (visit[i])
        {
            continue;
        }

        answer++;
        visit[i] = true;
        queue<int> q;
        q.push(i);
        while (!q.empty())
        {
            int x = q.front();
            q.pop();

            for (int k = 0; k < n; ++k)
            {
                if (computers[x][k] && visit[k] == false)
                {
                    visit[k] = true;
                    q.push(k);
                }
            }
        }
    }

    return answer;
}
