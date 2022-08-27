// [42587] 프린터
// 큐
#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
queue<int> printQ;
vector<int> priorityVec;

int solution(vector<int> priorities, int location) {
    int order = 0;
    for(int i = 0; i < priorities.size(); i++) {
        printQ.push(i);
        priorityVec.push_back(priorities[i]);
    }
    sort(priorityVec.rbegin(), priorityVec.rend()); // 내림차순 정렬
    
    while(!printQ.empty()) {
        int initIdx = printQ.front();
        printQ.pop();
        
        if(priorities[initIdx] >= priorityVec[0]) {
            order++;
            priorityVec.erase(priorityVec.begin());
            if(initIdx == location) return order;
        }
        else printQ.push(initIdx);
    }
    return order;
}