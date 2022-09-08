// [77885] 2개 이하로 다른 비트
#include <string>
#include <vector>
using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for(long long num : numbers) {
        if(num % 2 == 0) answer.push_back(num + 1);
        else {
            long long bit = 1;
            while(true) {
                // 연산자 우선순위: == > & -> 반드시 괄호 필요
                if((num & bit) == 0)  break; // 현재 비트가 0
                else bit <<= 1; // bit *= 2;
            }
            bit >>= 1; // bit /= 2
            answer.push_back(num + bit);
        }
    }
    return answer;
}