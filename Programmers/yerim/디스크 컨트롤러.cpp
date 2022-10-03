// [42627] 디스크 컨트롤러
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const vector<int> &a, const vector<int> &b) 
{
    return a[1] <= b[1];
}

int solution(vector<vector<int>> jobs) {
    int n = jobs.size(), answer = 0, currentTime = 0;
    sort(jobs.begin(), jobs.end(), cmp);
    
    while(!jobs.empty()) {
        for(int i = 0; i < jobs.size(); i++) {
            if(jobs[i][0] <= currentTime) {
                currentTime += jobs[i][1];
                answer += (currentTime - jobs[i][0]);
                jobs.erase(jobs.begin() + i);
                break;
            }
            if(i == jobs.size() - 1) currentTime++; // ex) 현재 3초인데 그 다음으로 빠른 작업이 4초일때 -> 휴식
        }
    }
    
    return answer / n;
}