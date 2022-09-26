// [1107] 리모컨
// 브루트포스
#include <iostream>
#include <string>
#include <cstdlib> // abs
#define MAX 1000000 // N = 500000번이고 2~9번이 모두 고장난 경우 1, 0으로 채널을 만들어야됨 -> 최대 1000000
using namespace std;

int n; 
bool state[10]; 

void input()
{
    int m, tmp;
    cin >> n >> m;
    for(int i = 0 ; i < 10 ; i++) state[i] = true; // init
    for(int i = 0 ; i < m ; i++) {
        cin >> tmp;
        state[tmp] = false;
    }
}

bool check(int num) {
	if(num == 0) {
		if(state[0] == false) return false;
		else return true;
	}
	while(num) {
		if(state[num % 10] == false) return false;
		num /= 10;
	}
	return true;
}

int getMin(int num)
{   
	int minPressCnt = MAX, pressCnt;
	for(int i = 0; i <= MAX ; i++) {
		if(check(i)) { // 고장난 번호 없이 누를 수 있는 경우
			pressCnt = to_string(i).length();
			pressCnt += abs(i - num);
			minPressCnt = min(minPressCnt, pressCnt);
		}
	}
	// 100번에서 + or - 로 계속 이동하는 것과 비교
	return min(abs(num - 100), minPressCnt);
}   

int main(void)
{
    input();
    cout << getMin(n) << '\n';
    return 0;
}