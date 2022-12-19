// 221219_BOJ_2665

#include <iostream>
#include <queue>

using namespace std;

int N, answer = -1;
bool visit[51][51][3000];
char maze[51][51];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

struct state
{
    int x, y, z;

    bool operator<(const state &X) const
    {
        return this->z > X.z;
    }
};
priority_queue<state> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> maze[i];
    }

    visit[0][0][0] = true;
    pq.push({0, 0, 0});
    while (!pq.empty())
    {
        int x = pq.top().x, y = pq.top().y, z = pq.top().z;
        pq.pop();

        if (x == N - 1 && y == N - 1)
        {
            answer = z;
            break;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= N)
            {
                continue;
            }
            if (maze[xx][yy] == '1' && visit[xx][yy][z] == false)
            {
                visit[xx][yy][z] = true;
                pq.push({xx, yy, z});
            }
            else if (maze[xx][yy] == '0' && visit[xx][yy][z + 1] == false)
            {
                visit[xx][yy][z + 1] = true;
                pq.push({xx, yy, z + 1});
            }
        }
    }
    cout << answer;

    return 0;
}
