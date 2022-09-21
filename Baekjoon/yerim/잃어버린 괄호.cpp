// [1541] 잃어버린 괄호
#include <iostream>
using namespace std;

string expression;
int sum = 0, num = 0;
bool state = true; // true: + , false: -

void checkState()
{
    if(state == false) sum -= num;
    else sum += num;
    num = 0;
}

int solve()
{
    for(int i = 0; i < expression.size(); i++) {
        if(expression[i] == '+') {
            checkState();
        }
        else if(expression[i] == '-') {
            checkState();
            state = false;
        }
        else { // 숫자
            num = num * 10 + (expression[i] - '0');
        }
    }
    // 제일 마지막 수
    checkState();
    return sum;
}

int main(void)
{
    cin.tie(NULL); 
    ios_base::sync_with_stdio(false);

    cin >> expression;
    cout << solve() << '\n';
    return 0;
}