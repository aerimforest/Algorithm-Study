#include <string>
#include <vector>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2)
{
    long long sum1 = 0, sum2 = 0;
    for (int q : queue1)
    {
        sum1 += q;
    }
    for (int q : queue2)
    {
        sum2 += q;
    }

    if ((sum1 + sum2) & 1)
    {
        return -1;
    }

    int answer = 0, start1 = 0, start2 = 0, qsize = queue1.size() * 4;
    while (sum1 != sum2)
    {
        if (sum1 < sum2)
        {
            sum2 -= queue2[start2];
            sum1 += queue2[start2];
            queue1.push_back(queue2[start2++]);
        }
        else
        {
            sum1 -= queue1[start1];
            sum2 += queue1[start1];
            queue2.push_back(queue1[start1++]);
        }
        answer++;

        if (answer > qsize)
        {
            answer = -1;
            break;
        }
    }

    return answer;
}
