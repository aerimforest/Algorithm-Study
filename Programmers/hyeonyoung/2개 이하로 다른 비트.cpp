#include <string>
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers)
{
    vector<long long> answer;
    for (long long x : numbers)
    {
        long long ans = x;
        for (int i = 0; i < 64; ++i)
        {
            if ((ans & ((long long)1 << i)) == 0)
            {
                ans |= ((long long)1 << i);
                if (i > 0)
                {
                    ans -= ((long long)1 << (i - 1));
                }
                break;
            }
        }

        answer.push_back(ans);
    }
    return answer;
}
