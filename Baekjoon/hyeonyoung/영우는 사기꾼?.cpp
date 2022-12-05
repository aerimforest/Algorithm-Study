// 221205_BOJ_14676

#include <iostream>
#include <vector>

using namespace std;

int N, M, K;
vector<int> build[100001];
int building[100001], indegree[100001];
bool answer = true;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < M; ++i)
    {
        int x, y;
        cin >> x >> y;
        build[x].push_back(y);
        indegree[y]++;
    }
    for (int i = 0; i < K; ++i)
    {
        int x, a;
        cin >> x >> a;

        if (!answer)
        {
            continue;
        }
        if (x == 1)
        {
            if (indegree[a] == 0)
            {
                if (building[a]++ == 0)
                {
                    for (int b : build[a])
                    {
                        indegree[b]--;
                    }
                }
            }
            else
            {
                answer = false;
            }
        }
        else if (x == 2)
        {
            if (--building[a] >= 0)
            {
                if (building[a] == 0)
                {
                    for (int b : build[a])
                    {
                        indegree[b]++;
                    }
                }
            }
            else
            {
                answer = false;
            }
        }
    }

    if (answer)
    {
        cout << "King-God-Emperor";
    }
    else
    {
        cout << "Lier!";
    }

    return 0;
}
