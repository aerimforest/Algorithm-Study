#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit)
{
    int answer = 0;

    sort(people.begin(), people.end());
    int x = 0, y = people.size() - 1;
    while (x <= y)
    {
        if (people[x] + people[y] <= limit)
        {
            x++;
            y--;
            answer++;
        }
        else
        {
            y--;
            answer++;
        }
    }

    return answer;
}
