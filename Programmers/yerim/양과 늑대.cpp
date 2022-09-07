// [92343] 양과 늑대
// dfs, 완전 탐색
#include <string>
#include <vector>
using namespace std;

vector<int> graph[17];
int ans = 1, s, w;

void dfs(int curNode, int w, int s, vector<int> nextNodes, vector<int> info) {
    if(info[curNode] == 0) s++;
    else w++;
    
    ans = max(ans, s);
    
    // 늑대 수 >= 양 수  -> 더 이상 탐색 진행하지 않음
    // 지금 당장은 양 수가 부족해서 탐색 진행하지 않는 것. 
    // nextNodes에 담겨있기 때문에 다른 곳에서 양을 모은 후 다시 탐색할 수 있음
    if(w >= s) return;
    
    for(int i = 0; i < nextNodes.size(); i++) {
        vector<int> next = nextNodes;
        next.erase(next.begin() + i);
        for(int j = 0; j < graph[nextNodes[i]].size(); j++) {
            next.push_back(graph[nextNodes[i]][j]);
        }
        dfs(nextNodes[i], w, s, next, info);
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    for(int i = 0; i < edges.size(); i++) {
        graph[edges[i][0]].push_back(edges[i][1]);
    }
    
    vector<int> nextNodes;
    for(int i = 0; i < graph[0].size(); i++) {
        nextNodes.push_back(graph[0][i]);
    }
    dfs(0, 0, 0, nextNodes, info);
    return ans;
}
