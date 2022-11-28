// 221114_BOJ_11000

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N;
pair<int, int> course[200001]; // S, T

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> course[i].first >> course[i].second;
    }
    sort(course, course + N);

    priority_queue<int> pq;
    pq.push(course[0].second);
    for (int i = 0; i < N; ++i)
    {
        if (-pq.top() <= course[i].first)
        {
            pq.pop();
            pq.push(-course[i].second);
        }
        else
        {
            pq.push(-course[i].second);
        }
    }
    cout << pq.size();

    return 0;
}
