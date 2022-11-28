#include <string>
#include <vector>

using namespace std;

int N, answer = -1;

bool visit[10];

void solve(int k, vector<vector<int>> dungeons)
{
    int cnt = 0;
    for (int i = 0; i < N; ++i)
    {
        if (visit[i])
        {
            cnt++;
        }
    }
    answer = max(answer, cnt);

    for (int i = 0; i < N; ++i)
    {
        if (visit[i])
        {
            continue;
        }

        if (k >= dungeons[i][0])
        {
            visit[i] = true;
            solve(k - dungeons[i][1], dungeons);
            visit[i] = false;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons)
{
    N = dungeons.size();

    solve(k, dungeons);

    return answer;
}
