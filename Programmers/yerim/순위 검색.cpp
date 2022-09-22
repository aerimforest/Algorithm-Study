// [72412] KAKAO BLIND RECRUITMENT 순위 검색
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <unordered_map>
using namespace std;

vector<int> answer, score;
unordered_map<string, vector<int>> um;

void makeCombi(string info)
{
    int num;
    stringstream ss(info);
    string tmpInfo[4][2] = {{"-"}, {"-"}, {"-"}, {"-"}};
    
    for(int i = 0; i < 4; i++) ss >> tmpInfo[i][1];
    ss >> num;
    score.push_back(num);
    
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            for(int k = 0; k < 2; k++) {
                for(int l = 0; l < 2; l++) {
                    string key = tmpInfo[0][i] + tmpInfo[1][j] + tmpInfo[2][k] + tmpInfo[3][l];  
                    um[key].push_back(num);
                }
            }
        }
    }
}

void findPeople(string info, int total)
{
    stringstream ss(info);
    string tmpInfo[8], key = "";
    
    for(int i = 0; i < 8; i++) ss >> tmpInfo[i];
    
    for(int i = 0; i < 8; i += 2) {
        if(tmpInfo[i] != "-") key += tmpInfo[i];
        else key += "-";
    }
    int idx = lower_bound(um[key].begin(), um[key].end(), (int)stoi(tmpInfo[7])) - um[key].begin();
    answer.push_back(um[key].size() - idx);
}

vector<int> solution(vector<string> info, vector<string> query) {
    for(auto str: info) {
        makeCombi(str); // 지원자의 정보로 가능한 모든 조합 찾기
    }
    for(auto iter = um.begin(); iter != um.end(); iter++) {
        sort(iter->second.begin(), iter->second.end());
    }
    for(auto str: query) {
        findPeople(str, info.size());
    }
    return answer;
}