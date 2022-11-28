// [12980] 점프와 순간 이동
#include <iostream>
using namespace std;

int solution(int n)
{
    int cost = 0;
    while(n > 0) {
        if(n % 2 == 0) {
            n /= 2;
        }
        else {
            cost++;
            n--;
        }
    }
    return cost;
}