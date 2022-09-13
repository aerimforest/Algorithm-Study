//42885

#include <string>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;

    sort(people.begin(), people.end());
    
    deque<int> dp(people.begin(), people.end());

    while(!dp.empty())
    {
        int n1 = dp.front();
        int n2 = dp.back();

        if(n1 + n2 > limit)
        {
            answer += 1;
            dp.pop_back();
        }
        
        else
        {
            answer += 1;
            dp.pop_back();
            if(dp.empty())
                break;
            dp.pop_front();
        }
    }
    
    return answer;
}