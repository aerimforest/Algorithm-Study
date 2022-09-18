// [118667] 두 큐 합 같게 만들기
#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum1 = 0, sum2 = 0, cnt = 0;
    queue<int> initQ1, initQ2, q1, q2;
    for(int i = 0; i < queue1.size(); i++) {
        initQ1.push(queue1[i]);
        q1.push(queue1[i]);
        sum1 += queue1[i];
    }
    for(int i = 0; i < queue2.size(); i++) {
        initQ2.push(queue2[i]);
        q2.push(queue2[i]);
        sum2 += queue2[i];
    }
    while(cnt <= queue1.size() * 4) {
        if(sum1 > sum2 && !queue1.empty()) {
            sum1 -= q1.front(); sum2 += q1.front();
            q2.push(q1.front());
            q1.pop();
        }
        else if(sum1 < sum2 && !q2.empty()) {
            sum2 -= q2.front(); sum1 += q2.front();
            q1.push(q2.front());
            q2.pop();
        }
        else { // sum1 == sum2
            return cnt;
        }
        cnt++;
    }
    return -1;
}