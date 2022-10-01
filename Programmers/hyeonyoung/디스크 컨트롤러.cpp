#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> jobs)
{
    int answer = 0, len = jobs.size();
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> job, heap;
    for (int i = 0; i < len; ++i)
    {
        job.push({jobs[i][0], jobs[i][1]});
    }

    int cur = 0;
    while (!job.empty() || !heap.empty())
    {
        while (!job.empty() && job.top().first <= cur)
        {
            heap.push({job.top().second, job.top().first});
            job.pop();
        }

        if (heap.empty())
        {
            cur++;
            continue;
        }

        answer += cur + heap.top().first - heap.top().second;
        cur += heap.top().first;
        heap.pop();
    }

    return answer / len;
}
