#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights)
{
    int now = 0, weight_sum = 0;
    queue<pair<int, int>> Q; // weight, time

    for (int x : truck_weights)
    {
        now++;
        if (now == Q.front().second)
        {
            weight_sum -= Q.front().first;
            Q.pop();
        }
        while (weight_sum + x > weight)
        {
            weight_sum -= Q.front().first;
            now = Q.front().second;
            Q.pop();
        }
        weight_sum += x;
        Q.push({x, now + bridge_length});
    }
    while (!Q.empty())
    {
        weight_sum -= Q.front().first;
        now = Q.front().second;
        Q.pop();
    }

    return now;
}
