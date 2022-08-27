// [67257] 수식 최대화
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

char order[3];
long long answer = 0;
bool visited[3];
vector<long long> num;
vector<char> operators, types;

void splitExpression(string expression)
{
    string s = "";
    for(int i = 0; i < expression.size(); i++) {
        if('0' <= expression[i] && expression[i] <= '9') {
            s += expression[i];
        }
        else {
            operators.push_back(expression[i]);
            types.push_back(expression[i]);
            num.push_back(stoi(s));
            s = "";
        }
    }
    num.push_back(stoi(s));
}

void findDifferetOperator()
{
    sort(types.begin(), types.end());
    types.erase(unique(types.begin(), types.end()), types.end());
}

long long calculate()
{
    vector<long long> tmpNum = num;
    vector<char> tmpOperators = operators;
    
    for(int i = 0; i < types.size(); i++) {
        for(int j = 0; j < tmpOperators.size(); j++) {
            if(tmpOperators[j] == order[i]) {
                if(tmpOperators[j] == '+') tmpNum[j] = tmpNum[j] + tmpNum[j+1];
                else if(tmpOperators[j] == '-') tmpNum[j] = tmpNum[j] - tmpNum[j+1];
                else tmpNum[j] = tmpNum[j] * tmpNum[j+1];
                tmpNum.erase(tmpNum.begin() + j + 1);
                tmpOperators.erase(tmpOperators.begin() + j);
                j--;
            }
        }
    }
    if(tmpNum[0] > 0) return tmpNum[0];
    else return -1*tmpNum[0];
}

void setOperatorOrder(int idx, int depth)
{
    if(depth == types.size()) {
        answer = max(answer, calculate());
        return;
    }
    
    for(int i = 0; i < types.size(); i++) {
        if(idx != i && visited[i] == false) {
            visited[i] = true;
            order[depth] = types[i];
            setOperatorOrder(i, depth + 1);
            visited[i] = false;
        }
    }
}

long long solution(string expression) {
    splitExpression(expression);
    findDifferetOperator();
    setOperatorOrder(-1, 0);
    
    return answer;
}