//67257
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

long long cal(long long a, long long b, char op)
{
    if(op == '-')
        return a - b;
    
    else if(op == '+')
        return a + b;
    
    else
        return a * b;
}

long long solution(string expression) {
    long long answer = 0;
    vector<char> op = {'*', '+', '-'};
    vector<char> opV;
    vector<long long> num;
    string n = "";

    for(int i = 0; i < expression.size(); i++)
    {
        if(expression[i] == '+' || expression[i] == '*' || expression[i] == '-')
        {
            opV.push_back(expression[i]);
            num.push_back(atoi(n.c_str()));
            n = "";
        }

        else
            n += expression[i];
    }

    num.push_back(atoi(n.c_str()));

    long long maxAns = 0;

    do
    {
        vector<char> tmp = opV;
        vector<long long> tmp_num = num;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < tmp.size(); j++)
            {
                if(tmp[j] == op[i])
                {
                    tmp_num[j] = cal(tmp_num[j], tmp_num[j+1], op[i]);
                    tmp_num.erase(tmp_num.begin() + j + 1);
                    tmp.erase(tmp.begin() + j);
                    j--;
                }
            }
        }

        if(maxAns < abs(tmp_num[0]))
            maxAns = abs(tmp_num[0]);

    } while (next_permutation(op.begin(), op.end()));

    answer = maxAns;

    return answer;
    
}


// 같은 순위 연산자 없음.
// 절대값으로 계산.

// expression 쪼개서 숫자/문자로 나누기.
// 연산자끼리 우선순위 바꿔가며 계산, max값 구하기