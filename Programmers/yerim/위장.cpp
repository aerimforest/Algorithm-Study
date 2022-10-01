// [42578] 위장
#include <string>
#include <vector>
#include <map>
using namespace std;

map<string, int> m;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    for(auto vec: clothes) {
        m[vec[1]]++;
    }
    for(auto info: m) {
        answer *= (info.second + 1);
    }

    return answer - 1;
}