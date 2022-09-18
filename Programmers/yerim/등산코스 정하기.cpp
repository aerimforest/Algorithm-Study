// [118669] 등산코스 정하기
// 다익스트라
#include <vector>
#include <queue>
using namespace std;

int nodes[50001], intensity[50001];
vector<vector<pair<int,int>>> graph(50001);

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    int ansIntensity = 1e9, summit = 1e9;
    for(int i = 1; i <= n; i++) intensity[i] = 1e8;
    for(int i = 0; i < summits.size(); i++) nodes[summits[i]] = 2;
    for(auto p: paths) {
        graph[p[0]].push_back({p[2], p[1]});
        graph[p[1]].push_back({p[2], p[0]});
    }

    priority_queue<pair<int,int>> pq;
    for(int i = 0; i < gates.size(); i++) {
        intensity[gates[i]] = -1; 
        pq.push({0, gates[i]});
    }

    while(!pq.empty()) {
        int maxIntensity = pq.top().first;
        int curNode = pq.top().second;
        pq.pop();
        
        if(maxIntensity > ansIntensity) continue;
        if(nodes[curNode] == 2) {
            if(maxIntensity < ansIntensity) {
                ansIntensity = maxIntensity;
                summit = curNode;
            }
            else if(maxIntensity == ansIntensity && curNode < summit) {
                summit = curNode;
            }
            continue;
        }

        for(auto next: graph[curNode]) {
            if(intensity[next.second] > max(maxIntensity, next.first)) {
                intensity[next.second] = max(maxIntensity, next.first);
                pq.push({intensity[next.second], next.second});
            } 
        }
    }
    return {summit, ansIntensity};
}