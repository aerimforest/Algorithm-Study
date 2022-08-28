// [42583] 다리를 지나는 트럭
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int ans = 0;
    int weightSum = 0; // 다리 위의 트럭 무게의 합
    queue<int> q;
    
    for(int i = 0; i < truck_weights.size(); i++) {
        while(true) {
            if(q.size() == bridge_length) { // 트럭 개수 최대
                weightSum -= q.front(); // 맨 앞의 트럭 제거
                q.pop();
            }
            if(truck_weights[i] + weightSum <= weight) {
                break;
            }
            q.push(0); // 무게가 L을 넘는 경우
            ans++;
        }
        q.push(truck_weights[i]);
        weightSum += truck_weights[i];
        ans++;
    }
    return ans + bridge_length;
}