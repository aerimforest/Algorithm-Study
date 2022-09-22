// [72411] 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼
// map<key, value> m -> <m.first, m.second>
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

unordered_map<string, int> m;
int maxCombi[11];

void makeCombi(string order, int num)
{
    if(order.length() >= num) {
        vector<bool> select;
        for(int i = 0; i < order.length() - num; i++) select.push_back(false); // 정렬된 상태를 만들어야 되기 때문에 반드시 0먼저 넣어야 함
        for(int i = 0; i < num; i++) select.push_back(true);
        
        do {
            string newCombi = "";
            for(int i = 0; i < order.length(); i++) {
                if(select[i]) newCombi += order[i];
            }
            m[newCombi]++;
            maxCombi[num] = max(maxCombi[num], m[newCombi]);
        } while(next_permutation(select.begin(), select.end()));
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    for(string &order: orders) sort(order.begin(), order.end());
    for(int c: course) {
        m.clear();
        for(auto order: orders) {
            makeCombi(order, c); // 메뉴 개수가 c개인 조합 전부 찾기
        }
        for(auto info: m) {
            if(info.second >= 2 && info.second == maxCombi[c]) {
                answer.push_back(info.first);
            }
        }
    }
    sort(answer.begin(), answer.end());
    
    return answer;
}